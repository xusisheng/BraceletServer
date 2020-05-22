package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.mapper.DeviceAlarmRecordMapper;
import com.aw.braceletserver.model.*;
import com.aw.braceletserver.service.DeviceManagerService;
import com.aw.braceletserver.service.HealthManagerService;
import com.aw.braceletserver.service.TxManagerService;
import com.aw.braceletserver.utils.DateUtil;
import com.aw.braceletserver.utils.SerialNo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TxManagerServiceImpl implements TxManagerService {
    private Logger logger = LoggerFactory.getLogger(TxDataServiceImpl.class);

    @Resource
    private DeviceManagerService deviceManagerService;

    @Resource
    HealthManagerService healthManagerService;
    
    @Resource
    private DeviceAlarmRecordMapper deviceAlarmRecordMapper;
    @Override
    public boolean uploadDeviceData(JSONObject data) {
        String notifyType =(String)data.get("notifyType");
        boolean flag =true;
        switch (notifyType){
            case "deviceDataChanged":
                JSONObject serviceData = data.getJSONObject("service");
                JSONObject dataJo = serviceData.getJSONObject("data");
                String deviceSeriNum = dataJo.getString("deviceid"); //设备sn,唯一标识
                if (StringUtils.isBlank(deviceSeriNum)){
                    return false;
                }
                Device device = deviceManagerService.getDeviceByImei(deviceSeriNum);
                if (device == null) {
                	logger.info("设备：{}不存在，新增该设备",deviceSeriNum);
                	String sim = data.getString("sim");//device-name
                    Device ndevice = new Device();
                    ndevice.setSerialNumber(deviceSeriNum);
                    ndevice.setDeviceName(sim);
                	Integer maxNo = deviceManagerService.selectMaxDeviceId();
                    ndevice.setDeviceId((maxNo == null)? 0: maxNo + 1);
                    deviceManagerService.addDevice(ndevice);
                    int r=deviceManagerService.bindDeviceToUserRole(33845, ndevice.getDeviceId());
                    if(r>0) {
                    	logger.info("绑定用户组成功");
                    }else {
                    	logger.info("绑定用户组失败");
                    }
                    //更新devicePosition表数据
                    addDevicePosition(dataJo, ndevice);
                    //更新health表
                    addDeviceHealth(dataJo, ndevice);
                }else{
                	//更新device表的deviceName
                    //updateDevice(dataJo, device);
                    //更新devicePosition表数据
                    addDevicePosition(dataJo, device);
                    //更新health表
                    addDeviceHealth(dataJo, device);
                    
                }
                
                logger.info("设备：{} 上报数据保存成功！",deviceSeriNum);
                break;
            default: return true;
        }
        return flag;
    }

    boolean updateDevice(JSONObject data, Device device){
        String sim = data.getString("sim");//device-name
        Device updateDevice = new Device();
        updateDevice.setSerialNumber(device.getSerialNumber());
        updateDevice.setDeviceName(sim);
        deviceManagerService.updateDevice(updateDevice);
        return true;
    }

    boolean addDevicePosition(JSONObject data, Device device){
        int deviceId = device.getDeviceId();
        String gps = data.getString("gps");
        float elevation = data.getFloatValue("elevation");//海拔
        String devicetime = data.getString("devicetime");//设备上送时间
        BigDecimal atmosphere = data.getBigDecimal("atmosphere");//气压
        Integer battery = data.getInteger("battery");//电量
        String msgType = data.getString("msgType");
        DevicePosition lastedDevicePosition = deviceManagerService.getLastedDevicePositionByDeviceId(deviceId);
        DevicePosition newDevicePosition = new DevicePosition();
        Integer maxNo = deviceManagerService.selectMaxDevicePositionId();
        newDevicePosition.setId((maxNo == null)? 0: maxNo + 1);
        newDevicePosition.setDeviceId(deviceId);
        Date deviceUtcTime=null;
        if (StringUtils.isNotBlank(gps)){
            String[] gpss = gps.split(",");
            newDevicePosition.setLongitude(new BigDecimal(gpss[0]));
            newDevicePosition.setLatitude(new BigDecimal(gpss[1]));
        }
        if (lastedDevicePosition != null){
            newDevicePosition.setoLongitude(lastedDevicePosition.getLongitude());
            newDevicePosition.setoLatitude(lastedDevicePosition.getLatitude());
        }
        //utc时间，日期减8小时
        if (StringUtils.isNotBlank(devicetime)){
        	deviceUtcTime= DateUtils.addHours(DateUtil.getDateFromString(devicetime), -8);
            newDevicePosition.setDeviceUtcTime(deviceUtcTime);
        }
        newDevicePosition.setPositionType(1);
        newDevicePosition.setAltitude(elevation);
        newDevicePosition.setAtmosphere(atmosphere);
        newDevicePosition.setBattery(battery);
        newDevicePosition.setOnlineStatus(1);
        deviceManagerService.addDevicePosition(newDevicePosition);
        if("deviceSos".equals(msgType)) {
        	logger.info("插入Sos数据");
        	DeviceAlarmRecord deviceAlarmRecord=new DeviceAlarmRecord();
        	deviceAlarmRecord.setUserId(33845);
        	deviceAlarmRecord.setSerialNumber(device.getSerialNumber());
        	deviceAlarmRecord.setAlarmName("SOS");
        	deviceAlarmRecord.setAlarmContent("设备紧急呼叫");
        	deviceAlarmRecord.setDeviceName(device.getDeviceName());
        	deviceAlarmRecord.setCreateTime(deviceUtcTime);
        	deviceAlarmRecord.setIsDelete(0);
        	deviceAlarmRecord.setDeviceId(deviceId);
        	deviceAlarmRecord.setLongitude(newDevicePosition.getLongitude());
        	deviceAlarmRecord.setLatitude(newDevicePosition.getLatitude());
        	deviceAlarmRecord.setAltitude(elevation);
        	deviceAlarmRecord.setBattery(battery);
        	deviceAlarmRecordMapper.insertSelective(deviceAlarmRecord);
        }
        return true;
    }

    boolean addDeviceHealth(JSONObject data, Device device){
        int deviceId = device.getDeviceId();
        Float heartbeat = data.getFloat("heartbeat");
        String devicetime = data.getString("devicetime");
        List<UserGroup> userGroupList = deviceManagerService.selectByDeviceId(deviceId);
        if (userGroupList == null || userGroupList.size() == 0){
            logger.warn("设备deviceId:{}未绑定用户", deviceId);
            return false;
        }
        UserGroup userGroup = userGroupList.get(0);
        Health newHealth = new Health();
        newHealth.setId(SerialNo.getUNID());
        newHealth.setDeviceSerialNum(device.getSerialNumber());
        newHealth.setUserId(userGroup.getUserId());
        if (heartbeat != null) newHealth.setHeartBeat(heartbeat);
        if (StringUtils.isNotBlank(devicetime)){
            newHealth.setCreateTime(DateUtils.addHours(DateUtil.getDateFromString(devicetime), -8));
        }
        healthManagerService.addHealth(newHealth);
        return true;
    }
}
