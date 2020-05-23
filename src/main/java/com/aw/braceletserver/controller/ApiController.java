package com.aw.braceletserver.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.entity.*;
import com.aw.braceletserver.enums.CommandEnum;
import com.aw.braceletserver.enums.StateEnum;
import com.aw.braceletserver.model.Device;
import com.aw.braceletserver.model.DevicePosition;
import com.aw.braceletserver.model.Health;
import com.aw.braceletserver.model.UserGroup;
import com.aw.braceletserver.properties.ApiUri;
import com.aw.braceletserver.service.*;
import com.aw.braceletserver.utils.JsonMapper;
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

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/Exchange")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private ApiUri apiUri;
    @Autowired
    private ApiService apiService;
    @Autowired
    private DeviceAlarmRecordService deviceAlarmRecordService;
    @Autowired
    private DeviceManagerService deviceManagerService;
    @Autowired
    private HealthManagerService healthManagerService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PostMapping("/logout")
    public String logout(UserInfo userInfo) {
        System.out.println("==========");
        deviceAlarmRecordService.selectRecordByDeviceId(0, 0);
        return "aaaaaa";
    }

    /**
     * 手环历史轨迹查询
     */
    @PostMapping("/shouhuan_getList")
    @ResponseBody
    public RespGetList getList(UserInfo userInfo, @RequestBody UnifyRequest<ReqGetList> request) throws Exception {
        JSONArray ja = request.getParams().getIdlist();
        Integer limit = request.getParams().getLimit();
        List<Integer> idlist = JsonMapper.toList(ja.toJSONString(), Integer.class);
        RespGetList<JSONArray> response = new RespGetList();

        //获取用户下所有手环
        List<UserGroup> listUserGroup = deviceManagerService.selectByUserId(userInfo.getItem().getUserId());
        if (listUserGroup == null || listUserGroup.size() == 0) {
            BeanUtils.copyProperties(UnifyResponse.success("用户目前未绑定设备"), response);
            return response;
        }

        //循环检测
        List<BraceletTrack> list = new ArrayList<>();
        for (int i = 0; i < listUserGroup.size(); i++) {
            // 判断是否需要查询的设备
            UserGroup userGroup = listUserGroup.get(i);
            Integer deviceId = userGroup.getDeviceId();
            if (!idlist.contains(deviceId)) {
                //不是
                continue;
            }

            //查询设备最后的位置
            DevicePosition devicePosition = deviceManagerService.getLastedDevicePositionByDeviceId(deviceId);
            BraceletTrack braceletTrack = new BraceletTrack();
            braceletTrack.setRecord_time(devicePosition.getDeviceUtcTime() == null ? "" : sdf.format(devicePosition.getDeviceUtcTime()));
            braceletTrack.setLon(String.valueOf(devicePosition.getLongitude()));
            braceletTrack.setLat(String.valueOf(devicePosition.getLatitude()));
            braceletTrack.setDevid(String.valueOf(deviceId));
            braceletTrack.setAt(String.valueOf(devicePosition.getAltitude()));
            list.add(braceletTrack);
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
    public UnifyResponse getStatus(UserInfo userInfo, @RequestBody UnifyRequest<ReqIdList> request)
    {
        List<Integer> idlist = JsonMapper.toList(request.getParams().getIdlist().toJSONString(), Integer.class);

        //获取用户下所有手环信息
        List<UserGroup> listUserGroup = deviceManagerService.selectByUserId(userInfo.getItem().getUserId());
        if (listUserGroup == null || listUserGroup.size() == 0) {
            return UnifyResponse.success("用户目前未绑定设备");
        }

        JSONArray ja = new JSONArray();
        for (int i = 0; i < listUserGroup.size(); i++) {
            // 判断是否需要查询的设备
            UserGroup userGroup = listUserGroup.get(i);
            Integer deviceId = userGroup.getDeviceId();
            if (!idlist.contains(deviceId)) {
                //不是
                continue;
            }

            //查询设备最后的位置
            DevicePosition devicePosition = deviceManagerService.getLastedDevicePositionByDeviceId(deviceId);
            BraceletStatus braceletStatus = new BraceletStatus();
            braceletStatus.setDevid(String.valueOf(deviceId));
            if(offStatus(devicePosition.getDeviceUtcTime())) {
                braceletStatus.setIsonline(false);
            } else {
                braceletStatus.setIsonline(true);
            }
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
    public UnifyResponse setStatus(UserInfo userInfo, @RequestBody UnifyRequest<ReqSetStatus> request)
    {
        return UnifyResponse.success("无法远程关机，故接口无效");
    }

    /**
     * 手环位置心率数据根据手环ID实时查询
     */
    @PostMapping("/shouhuan_getHrInfo")
    @ResponseBody
    public UnifyResponse getHrInfo(UserInfo userInfo, @RequestBody UnifyRequest<ReqIdList> request)
    {
        List<Integer> idlist = JsonMapper.toList(request.getParams().getIdlist().toJSONString(), Integer.class);

        //获取用户下所有手环信息
        List<UserGroup> listUserGroup = deviceManagerService.selectByUserId(userInfo.getItem().getUserId());
        if (listUserGroup == null || listUserGroup.size() == 0) {
            return UnifyResponse.success("用户目前未绑定设备");
        }

        JSONArray ja = new JSONArray();
        for (int i = 0; i < listUserGroup.size(); i++) {
            // 判断是否需要查询的设备
            UserGroup userGroup = listUserGroup.get(i);
            Integer deviceId = userGroup.getDeviceId();
            if (!idlist.contains(deviceId)) {
                //不是
                continue;
            }

            //查询设备
            Device device =deviceManagerService.getDeviceByDeviceId(deviceId);
            //查询设备最后的位置
            DevicePosition devicePosition = deviceManagerService.getLastedDevicePositionByDeviceId(deviceId);
            //查询健康数据
            Date endTime = devicePosition.getDeviceUtcTime();
            Date startTime = DateUtils.addMinutes(endTime, -20);
            List<Health> listHealth = healthManagerService.getHealthByUserDevice(userGroup.getUserId(), device.getSerialNumber(),startTime, endTime);

            BraceletInfo braceletInfo = new BraceletInfo();
            braceletInfo.setRecord_time(devicePosition.getDeviceUtcTime() == null ? "" : sdf.format(devicePosition.getDeviceUtcTime()));
            braceletInfo.setLon(String.valueOf(devicePosition.getLongitude()));
            braceletInfo.setLat(String.valueOf(devicePosition.getLatitude()));
            braceletInfo.setAt(String.valueOf(devicePosition.getAltitude()));
            braceletInfo.setDevid(String.valueOf(deviceId));
            if (listHealth.size() > 0) {
                //有健康数据
                braceletInfo.setHr(String.valueOf(listHealth.get(0).getHeartBeat()));
            }
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

    /**
     * 手环位置心率数据根据中心点半径实时查询
     */
    @PostMapping("/shouhuan_getPositionInfo")
    @ResponseBody
    public UnifyResponse getPositionInfo(UserInfo userInfo, @RequestBody UnifyRequest<ReqPositionInfo> request)
    {
        ReqPositionInfo req = request.getParams();
        Double radio = Double.parseDouble(req.getRadio());
        GlobalCoordinates source = new GlobalCoordinates(Double.parseDouble(req.getLon()), Double.parseDouble(req.getLat()));

        //获取用户下所有手环信息
        List<UserGroup> listUserGroup = deviceManagerService.selectByUserId(userInfo.getItem().getUserId());
        if (listUserGroup == null || listUserGroup.size() == 0) {
            return UnifyResponse.success("用户目前未绑定设备");
        }

        JSONArray ja = new JSONArray();
        for (int i = 0; i < listUserGroup.size(); i++) {
            // 判断是否需要查询的设备
            UserGroup userGroup = listUserGroup.get(i);
            Integer deviceId = userGroup.getDeviceId();

            //查询设备最后的位置
            DevicePosition devicePosition = deviceManagerService.getLastedDevicePositionByDeviceId(deviceId);

            //计算该设备与原点之间距离 Ellipsoid.Sphere 或者 Ellipsoid.WGS84
            GlobalCoordinates target = new GlobalCoordinates(devicePosition.getLongitude().doubleValue(), devicePosition.getLatitude().doubleValue());
            Double distince = getDistanceMeter(source, target, Ellipsoid.Sphere);
            if (distince > radio) {
                //设备超出距离
                continue;
            }

            //查询设备
            Device device =deviceManagerService.getDeviceByDeviceId(deviceId);
            //查询健康数据
            Date endTime = devicePosition.getDeviceUtcTime();
            Date startTime = DateUtils.addMinutes(endTime, -20);
            List<Health> listHealth = healthManagerService.getHealthByUserDevice(userGroup.getUserId(), device.getSerialNumber(),startTime, endTime);

            BraceletInfo braceletInfo = new BraceletInfo();
            braceletInfo.setRecord_time(devicePosition.getDeviceUtcTime() == null ? "" : sdf.format(devicePosition.getDeviceUtcTime()));
            braceletInfo.setLon(String.valueOf(devicePosition.getLongitude()));
            braceletInfo.setLat(String.valueOf(devicePosition.getLatitude()));
            braceletInfo.setAt(String.valueOf(devicePosition.getAltitude()));
            braceletInfo.setDevid(String.valueOf(deviceId));
            if (listHealth.size() > 0) {
                //有健康数据
                braceletInfo.setHr(String.valueOf(listHealth.get(0).getHeartBeat()));
            }
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
    public UnifyResponse setWarningInfo(UserInfo userInfo, @RequestBody UnifyRequest<ReqResultList> request)
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
                    //保存指令
                    //TODO 如何下发到设备？数据库没有设备命令表
//                    deviceCommandManagerService.saveCommand(deviceId, deviceModel, commandEnum, params, responseObject);
                    break;
                default:
                    break;
            }
        }
        return UnifyResponse.success();
    }

    /**
     * 手环推送信息
     * 指张家口滑雪场需要获得的手环信息，通过socket推送，现在改为通过get接口获取，但是获取哪个手环的信息呢？
     */
    @PostMapping("/shouhuan_getInfo")
    @ResponseBody
    public RespGetInfo getPushInfo(UserInfo userInfo, @RequestBody(required = false) UnifyRequest request)
    {
        RespGetInfo<JSONArray> response = new RespGetInfo();
        response.setCode(0);

        JSONArray ja = new JSONArray();
        BraceletPushInfo bt1 = new BraceletPushInfo();
        bt1.setLon("114.034833");
        bt1.setLat("22.539651");
        bt1.setDeviceId("10000");
        bt1.setUpTime(new Date().getTime());
        ja.add(bt1);
        BraceletPushInfo bt2 = new BraceletPushInfo();
        bt2.setLon("114.034842");
        bt2.setLat("22.539812");
        bt2.setDeviceId("10001");
        bt2.setUpTime(new Date().getTime());
        ja.add(bt2);
        response.setResult(ja);
        return response;
    }

    /**
     * 运营商从厂商平台接收到手环SOS信息后的反馈接口
     */
    @GetMapping("/shouhuan_sosFeedback")
    @ResponseBody
    public UnifyResponse sosFeedback(UserInfo userInfo,
                                     @RequestParam("bang_id") String bangId,
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
