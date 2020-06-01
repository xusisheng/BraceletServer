package com.aw.braceletserver.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.constants.Constants;
import com.aw.braceletserver.entity.*;
import com.aw.braceletserver.enums.CommandEnum;
import com.aw.braceletserver.enums.StateEnum;
import com.aw.braceletserver.model.Device;
import com.aw.braceletserver.model.DevicePosition;
import com.aw.braceletserver.model.UserDevice;
import com.aw.braceletserver.service.*;
import com.aw.braceletserver.utils.JsonMapper;
import com.aw.braceletserver.utils.JsonUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

/**
 * 客户端接口（张家口滑雪场）
 */
@RestController
@RequestMapping("/api/Exchange")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private IotService iotService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserDeviceService userDeviceService;
    @Autowired
    private DevicePositionService devicePositionService;

    String partterns[] = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"
    };

    @PostMapping("/logout")
    public String logout() {
        System.out.println("==========");
        return "aaaaaa";
    }

    /**
     * 手环历史轨迹查询
     */
    @PostMapping("/shouhuan_getList")
    @ResponseBody
    public RespGetList getList(@RequestBody UnifyRequest<ReqGetList> request) throws Exception {
        JSONArray ja = request.getParams().getIdlist();
        String startTime = request.getParams().getBegin_time();
        String endTime = request.getParams().getEnd_time();
        Integer limit = request.getParams().getLimit();
        List<String> idlist = JsonMapper.toList(ja.toJSONString(), String.class);
        RespGetList<JSONArray> response = new RespGetList();

        //获取用户指定设备ID的列表，过滤不存在的设备
        List<Device> listDevice = deviceService.selectBySnSet(Constants.USERID, idlist.toArray(new String[0]));
        if (listDevice == null || listDevice.size() == 0) {
            BeanUtils.copyProperties(UnifyResponse.success("用户目前未绑定设备"), response);
            return response;
        }

        //循环检测
        List<BraceletTrack> list = new ArrayList<>();
        int sizeListUD = listDevice.size();
        for (int i = 0; i < sizeListUD; i++) {
            //查询设备位置
            Long deviceId = listDevice.get(i).getId();
            List<DevicePosition> listDevicePosition = devicePositionService.getLastestNByDeviceId(deviceId, startTime, endTime, limit);
            int sizeListDP = listDevicePosition.size();
            for (int j = 0; j < sizeListDP; j++) {
                DevicePosition devicePosition = listDevicePosition.get(j);
                BraceletTrack braceletTrack = new BraceletTrack();
                braceletTrack.setRecord_time(devicePosition.getUptime() == null ? "" : DateFormatUtils.ISO_DATETIME_FORMAT.format(devicePosition.getUptime()));
                braceletTrack.setLon(String.valueOf(devicePosition.getLongitude()));
                braceletTrack.setLat(String.valueOf(devicePosition.getLatitude()));
                braceletTrack.setDevid(String.valueOf(deviceId));
                braceletTrack.setAt(String.valueOf(devicePosition.getAltitude()));
                list.add(braceletTrack);
            }
        }
        BeanUtils.copyProperties(UnifyResponse.success(), response);
        response.setResult(list);
        response.setTotal_num(list.size());
        return response;
    }

    /**大于30分钟手环未上报数据，判定为关机状态*/
    private boolean offStatus(Date deviceUtcTime) {
        if(deviceUtcTime==null) return true;
        Date deviceDate = DateUtils.addHours(deviceUtcTime, 8);
        Date compareDate =DateUtils.addMinutes(deviceDate, 30);
        if(compareDate.before(new Date())) {
            return true;
        }
        return false;
    }

    /**
     * 手环设备状态查询
     */
    @PostMapping("/shouhuan_getStatus")
    @ResponseBody
    public UnifyResponse getStatus(@RequestBody UnifyRequest<ReqIdList> request)
    {
        List<String> idlist = JsonMapper.toList(request.getParams().getIdlist().toJSONString(), String.class);
        List<Device> listDevice = deviceService.selectBySnSet(Constants.USERID, idlist.toArray(new String[0]));
        JSONArray ja = new JSONArray();
        int sizeLd = listDevice.size();
        for (int i = 0; i < sizeLd; i++) {
            Device device = listDevice.get(i);
            BraceletStatus braceletStatus = new BraceletStatus();
            braceletStatus.setDevid(String.valueOf(device.getId()));
            //TODO 状态，1:ONLINE、0:OFFLINE、-1:ABNORMAL-----0未启用，1运动中，2静止，3离线(
            braceletStatus.setIsonline(device.getStatus() == 1);
            ja.add(braceletStatus);
        }
        UnifyResponse<JSONArray> response = UnifyResponse.success();
        response.setResult(ja);
        return response;
    }

    /**
     * 手环状态设置（无法远程关机，故接口无效）
     */
    @PostMapping("/shouhuan_setStatus")
    @ResponseBody
    public UnifyResponse setStatus(@RequestBody UnifyRequest<ReqSetStatus> request)
    {
        return UnifyResponse.success("无法远程关机，故接口无效");
    }

    /**
     * 手环位置心率数据根据手环ID实时查询
     */
    @PostMapping("/shouhuan_getHrInfo")
    @ResponseBody
    public UnifyResponse getHrInfo(@RequestBody UnifyRequest<ReqIdList> request)
    {
        List<String> idlist = JsonMapper.toList(request.getParams().getIdlist().toJSONString(), String.class);

        //获取用户下所有手环信息
        List<DevicePosition> listDevicePosition = devicePositionService.selectLastestBySnSet(Constants.USERID, idlist.toArray(new String[0]));
        JSONArray ja = new JSONArray();
        int sizeLDP = listDevicePosition.size();
        for (int i = 0; i < sizeLDP; i++) {
            BraceletInfo braceletInfo = new BraceletInfo();
            genBraceletInfo(braceletInfo, listDevicePosition.get(i));
            ja.add(braceletInfo);
        }
        UnifyResponse<JSONArray> response = UnifyResponse.success();
        response.setResult(ja);
        return response;
    }

    /**
     * 计算两点（经纬度）之间距离
     *
     * @param gpsFrom
     * @param gpsTo
     * @param ellipsoid
     * @return 返回距离（米）
     */
    public static double getDistanceMeter(GlobalCoordinates gpsFrom, GlobalCoordinates gpsTo, Ellipsoid ellipsoid) {
        //创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        GeodeticCurve geoCurve = new GeodeticCalculator().calculateGeodeticCurve(ellipsoid, gpsFrom, gpsTo);
        return geoCurve.getEllipsoidalDistance();
    }

    private void genBraceletInfo(BraceletInfo braceletInfo, DevicePosition devicePosition) {
        braceletInfo.setRecord_time(devicePosition.getUptime() == null ? "" : DateFormatUtils.ISO_DATETIME_FORMAT.format(devicePosition.getUptime()));
        braceletInfo.setLon(String.valueOf(devicePosition.getLongitude()));
        braceletInfo.setLat(String.valueOf(devicePosition.getLatitude()));
        braceletInfo.setAt(String.valueOf(devicePosition.getAltitude()));
        braceletInfo.setDevid(String.valueOf(devicePosition.getDeviceId()));
        braceletInfo.setHr(String.valueOf(devicePosition.getHeartBeat()));
    }

    /**
     * 手环位置心率数据根据中心点半径实时查询
     */
    @PostMapping("/shouhuan_getPositionInfo")
    @ResponseBody
    public UnifyResponse getPositionInfo(@RequestBody UnifyRequest<ReqPositionInfo> request)
    {
        ReqPositionInfo req = request.getParams();
        Double radio = Double.parseDouble(req.getRadio());
        GlobalCoordinates source = new GlobalCoordinates(Double.parseDouble(req.getLat()), Double.parseDouble(req.getLon()));

        //获取用户下所有手环信息
        List<DevicePosition> listDevicePosition = devicePositionService.selectLastestByUserId(Constants.USERID);
        JSONArray ja = new JSONArray();
        int sizeLDP = listDevicePosition.size();
        for (int i = 0; i < sizeLDP; i++) {
            DevicePosition devicePosition = listDevicePosition.get(i);

            //计算该设备与原点之间距离 Ellipsoid.Sphere 或者 Ellipsoid.WGS84
            GlobalCoordinates target = new GlobalCoordinates(devicePosition.getLatitude().doubleValue(), devicePosition.getLongitude().doubleValue());
            Double distince = getDistanceMeter(source, target, Ellipsoid.Sphere);
            if (distince > radio) {
                //设备超出距离
                continue;
            }

            //返回结构赋值
            BraceletInfo braceletInfo = new BraceletInfo();
            genBraceletInfo(braceletInfo, devicePosition);
            ja.add(braceletInfo);
        }
        UnifyResponse<JSONArray> response = UnifyResponse.success();
        response.setResult(ja);
        return response;
    }

    /**
     * 手环告警事件阈值设置
     */
    @PostMapping("/shouhuan_setWarningInfo")
    @ResponseBody
    public UnifyResponse setWarningInfo(@RequestBody UnifyRequest<ReqResultList> request)
    {
        JSONArray ja = request.getParams().getResult();
        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            WarningInfo warningInfo = jo.toJavaObject(WarningInfo.class);
            switch(warningInfo.getType()) {
                case 1:     //心率
                    //TODO 心率参数格式检查
                    String[] item = warningInfo.getValueinfo().split("-");
                    //TODO 验证设备在线
                    CommandEnum commandEnum = CommandEnum.getCommandEnumByCode("NB03");
                    if (commandEnum == null) {
                        UnifyResponse<JSONArray> response = UnifyResponse.failed("未知的指令");
                        response.setErrorcode(StateEnum.OTHER.getCode());
                        return response;
                    }
                    //TODO 如何下发到设备？数据库没有设备命令表
                    try {
                        ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"length\": 13, \"content\": \"SOS Confirmed\"}");
//                      iotService.deviceCommonds();
//                      deviceCommandManagerService.saveCommand(deviceId, deviceModel, commandEnum, params, responseObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        return UnifyResponse.success();
    }

    private void generatePushInfo(int type, List<Map<String, Object>> list, JSONArray ja) {
        for (Map<String, Object> item: list) {
            PushInfo pushInfo = new PushInfo();
            //bloodPressure 血压   bloodSugar 血糖
            pushInfo.setType(type);
            pushInfo.setAltitude(String.valueOf(item.get("altitude")));
            pushInfo.setDbp(Float.parseFloat(String.valueOf(item.get("disastolic"))));
            pushInfo.setSbp(Float.parseFloat(String.valueOf(item.get("shrink"))));
            pushInfo.setDeviceId(String.valueOf(item.get("deviceId")));
            pushInfo.setDirection(0);
            pushInfo.setHeartRate(Float.valueOf(String.valueOf(item.get("heartBeat"))).intValue());
            pushInfo.setLon(String.valueOf(item.get("longitude")));
            pushInfo.setLat(String.valueOf(item.get("latitude")));
            pushInfo.setSpeed(0);
            try {
                Date dt = DateUtils.parseDate(String.valueOf(item.get("deviceUtcTime")), partterns);
                pushInfo.setUpTime(dt.getTime());
            } catch (ParseException e) {
                //无采集时间
                pushInfo.setUpTime(0L);
            }
            ja.add(pushInfo);
        }
    }
    /**
     * 手环推送信息
     * 指张家口滑雪场需要获得的手环信息，通过socket推送，现在改为通过get接口获取
     */
    @PostMapping("/shouhuan_getInfo")
    @ResponseBody
    public UnifyResponse getPushInfo(@RequestBody(required = false) UnifyRequest request)
    {
        //查询用户所有设备信息
//        List<Map<String, Object>> listGps = deviceService.selectDeviceDataByUserId(userInfo.getItem().getUserId());
//        if (listGps == null || listGps.size() == 0) {
//            return UnifyResponse.success("用户目前未绑定设备");
//        }

        //查询用户所有告警设备信息
//        List<Map<String, Object>> listAlarm = deviceAlarmRecordService.selectAlarmDeviceDataByUserId(
//                userInfo.getItem().getUserId(), 0, "2020-01-02 12:55:45", 100000);
//
//        //组合返回数据
        JSONArray ja = new JSONArray();
//        generatePushInfo(Constants.PushInfoType.GPS, listGps, ja);
//        generatePushInfo(Constants.PushInfoType.SOS, listAlarm, ja);

        UnifyResponse<JSONArray> response = UnifyResponse.success();
        response.setResult(ja);
        return response;
    }

    /**
     * 运营商从厂商平台接收到手环SOS信息后的反馈接口
     */
    @GetMapping("/shouhuan_sosFeedback")
    @ResponseBody
    public UnifyResponse sosFeedback(@RequestParam("bang_id") String bangId,
                                     @RequestParam("time") String time,
                                     @RequestParam("sing") String sing)
    {
        String str = bangId + "_" + time + "_dhcc";
        String sign = DigestUtils.md5DigestAsHex(str.getBytes());
        if (StringUtils.equals(sign, sing)) {
            return UnifyResponse.success();
        } else {
            return UnifyResponse.failed();
        }
    }
}
