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
import com.aw.braceletserver.properties.ApiUri;
import com.aw.braceletserver.service.*;
import com.aw.braceletserver.utils.JsonMapper;
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
    private ApiUri apiUri;
    @Autowired
    private ApiService apiService;
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
    public String logout(UserInfo userInfo) {
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
        List<Long> idlist = JsonMapper.toList(ja.toJSONString(), Long.class);
        RespGetList<JSONArray> response = new RespGetList();

        //获取用户指定设备ID的列表，过滤不存在的设备
        Long[] ids = idlist.toArray(new Long[0]);
        List<UserDevice> listUserDevice = userDeviceService.selectByIdSet(Constants.USERID, ids);
        if (listUserDevice == null || listUserDevice.size() == 0) {
            BeanUtils.copyProperties(UnifyResponse.success("用户目前未绑定设备"), response);
            return response;
        }

        //循环检测
        List<BraceletTrack> list = new ArrayList<>();
        int sizeListUD = listUserDevice.size();
        for (int i = 0; i < sizeListUD; i++) {
            //查询设备位置
            Long deviceId = listUserDevice.get(i).getDeviceId();
            List<DevicePosition> listDevicePosition = devicePositionService.getLastedNDevicePositionByDeviceId(deviceId, startTime, endTime, limit);
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
    public UnifyResponse getStatus(UserInfo userInfo, @RequestBody UnifyRequest<ReqIdList> request)
    {
        List<Integer> idlist = JsonMapper.toList(request.getParams().getIdlist().toJSONString(), Integer.class);

        //获取用户下所有手环信息
        List<UserDevice> listUserDevice = deviceService.selectByUserId(userInfo.getItem().getUserId());
        if (listUserDevice == null || listUserDevice.size() == 0) {
            return UnifyResponse.success("用户目前未绑定设备");
        }

        JSONArray ja = new JSONArray();
        for (int i = 0; i < listUserDevice.size(); i++) {
            // 判断是否需要查询的设备
            UserDevice userDevice = listUserDevice.get(i);
            Long deviceId = userDevice.getDeviceId();
            if (!idlist.contains(deviceId)) {
                //不是
                continue;
            }

            //查询设备最后的位置
            DevicePosition devicePosition = deviceService.getLastedDevicePositionByDeviceId(deviceId);
            BraceletStatus braceletStatus = new BraceletStatus();
            braceletStatus.setDevid(String.valueOf(deviceId));
//            if(offStatus(devicePosition.getDeviceUtcTime())) {
//                braceletStatus.setIsonline(false);
//            } else {
//                braceletStatus.setIsonline(true);
//            }
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
        List<UserDevice> listUserDevice = deviceService.selectByUserId(userInfo.getItem().getUserId());
        if (listUserDevice == null || listUserDevice.size() == 0) {
            return UnifyResponse.success("用户目前未绑定设备");
        }

        JSONArray ja = new JSONArray();
        for (int i = 0; i < listUserDevice.size(); i++) {
            // 判断是否需要查询的设备
            UserDevice userDevice = listUserDevice.get(i);
            Long deviceId = userDevice.getDeviceId();
            if (!idlist.contains(deviceId)) {
                //不是
                continue;
            }

            //查询设备
            Device device = deviceService.getDeviceByDeviceId(deviceId);
            //查询设备最后的位置
            DevicePosition devicePosition = deviceService.getLastedDevicePositionByDeviceId(deviceId);
            //查询健康数据
//            Date endTime = devicePosition.getDeviceUtcTime();
//            Date startTime = DateUtils.addMinutes(endTime, -20);
//            List<Health> listHealth = healthService.getHealthByUserDevice(userDevice.getUserId(), device.getSerialNumber(),startTime, endTime);
//
//            BraceletInfo braceletInfo = new BraceletInfo();
//            braceletInfo.setRecord_time(devicePosition.getDeviceUtcTime() == null ? "" : DateFormatUtils.ISO_DATETIME_FORMAT.format(devicePosition.getDeviceUtcTime()));
//            braceletInfo.setLon(String.valueOf(devicePosition.getLongitude()));
//            braceletInfo.setLat(String.valueOf(devicePosition.getLatitude()));
//            braceletInfo.setAt(String.valueOf(devicePosition.getAltitude()));
//            braceletInfo.setDevid(String.valueOf(deviceId));
//            if (listHealth.size() > 0) {
//                //有健康数据
//                braceletInfo.setHr(String.valueOf(listHealth.get(0).getHeartBeat()));
//            }
//            ja.add(braceletInfo);
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
        List<UserDevice> listUserDevice = deviceService.selectByUserId(userInfo.getItem().getUserId());
        if (listUserDevice == null || listUserDevice.size() == 0) {
            return UnifyResponse.success("用户目前未绑定设备");
        }

        JSONArray ja = new JSONArray();
        for (int i = 0; i < listUserDevice.size(); i++) {
            // 判断是否需要查询的设备
            UserDevice userDevice = listUserDevice.get(i);
            Long deviceId = userDevice.getDeviceId();

            //查询设备最后的位置
            DevicePosition devicePosition = deviceService.getLastedDevicePositionByDeviceId(deviceId);

            //计算该设备与原点之间距离 Ellipsoid.Sphere 或者 Ellipsoid.WGS84
            GlobalCoordinates target = new GlobalCoordinates(devicePosition.getLongitude().doubleValue(), devicePosition.getLatitude().doubleValue());
            Double distince = getDistanceMeter(source, target, Ellipsoid.Sphere);
            if (distince > radio) {
                //设备超出距离
                continue;
            }

            //查询设备
            Device device = deviceService.getDeviceByDeviceId(deviceId);
            //查询健康数据
//            Date endTime = devicePosition.getDeviceUtcTime();
//            Date startTime = DateUtils.addMinutes(endTime, -20);
//            List<Health> listHealth = healthService.getHealthByUserDevice(userDevice.getUserId(), device.getSerialNumber(),startTime, endTime);
//
//            BraceletInfo braceletInfo = new BraceletInfo();
//            braceletInfo.setRecord_time(devicePosition.getDeviceUtcTime() == null ? "" : DateFormatUtils.ISO_DATETIME_FORMAT.format(devicePosition.getDeviceUtcTime()));
//            braceletInfo.setLon(String.valueOf(devicePosition.getLongitude()));
//            braceletInfo.setLat(String.valueOf(devicePosition.getLatitude()));
//            braceletInfo.setAt(String.valueOf(devicePosition.getAltitude()));
//            braceletInfo.setDevid(String.valueOf(deviceId));
//            if (listHealth.size() > 0) {
//                //有健康数据
//                braceletInfo.setHr(String.valueOf(listHealth.get(0).getHeartBeat()));
//            }
//            ja.add(braceletInfo);
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
    public UnifyResponse getPushInfo(UserInfo userInfo, @RequestBody(required = false) UnifyRequest request)
    {
        //查询用户所有设备信息
        List<Map<String, Object>> listGps = deviceService.selectDeviceDataByUserId(userInfo.getItem().getUserId());
        if (listGps == null || listGps.size() == 0) {
            return UnifyResponse.success("用户目前未绑定设备");
        }

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
