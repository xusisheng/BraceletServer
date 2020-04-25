package com.aw.braceletserver.controller;

import com.alibaba.fastjson.JSONArray;
import com.aw.braceletserver.entity.*;
import com.aw.braceletserver.utils.JsonMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/Exchange")
public class ApiController {

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(UserInfo userInfo) {
        System.out.println("==========");
        return "aaaaaa";
    }

    /**
     * 手环历史轨迹查询
     */
    @PostMapping("/shouhuan_getList")
    @ResponseBody
    public RespGetList getList(@RequestBody UnifyRequest<ReqGetList> request)
    {
        ReqGetList reqGetList = request.getParams();
        System.out.println(JsonMapper.toJson(reqGetList));

        RespGetList<JSONArray> response = new RespGetList();
        response.setDescription("SUCCESS");
        response.setErrorcode(0);

        JSONArray ja = new JSONArray();
        BraceletTrack bt1 = new BraceletTrack();
        bt1.setRecord_time("2018-11-22 01:56:45");
        bt1.setLon("114.034833");
        bt1.setLat("22.539651");
        bt1.setDevid("10000");
        bt1.setAt("0");
        ja.add(bt1);
        BraceletTrack bt2 = new BraceletTrack();
        bt2.setRecord_time("2018-11-22 07:07:28");
        bt2.setLon("114.034842");
        bt2.setLat("22.539812");
        bt2.setDevid("10001");
        bt2.setAt("0");
        ja.add(bt2);
        response.setTotal_num(2);
        response.setResult(ja);
        return response;
    }

    /**
     * 手环设备状态查询
     */
    @PostMapping("/shouhuan_getStatus")
    @ResponseBody
    public UnifyResponse getStatus(@RequestBody UnifyRequest<ReqIdList> request)
    {
        ReqIdList idList = request.getParams();
        System.out.println(JsonMapper.toJson(idList));

        UnifyResponse<JSONArray> response = new UnifyResponse();
        response.setDescription("SUCCESS");
        response.setErrorcode(0);

        JSONArray ja = new JSONArray();
        BraceletStatus bs1 = new BraceletStatus();
        bs1.setIsonline(true);
        bs1.setDevid("10000");
        ja.add(bs1);
        BraceletStatus bs2 = new BraceletStatus();
        bs2.setIsonline(false);
        bs2.setDevid("10000");
        ja.add(bs2);
        response.setResult(ja);
        return response;
    }

    /**
     * 手环状态设置
     */
    @PostMapping("/shouhuan_setStatus")
    @ResponseBody
    public UnifyResponse setStatus(@RequestBody UnifyRequest<ReqSetStatus> request)
    {
        ReqSetStatus req = request.getParams();
        System.out.println(JsonMapper.toJson(req));

        UnifyResponse<JSONArray> response = new UnifyResponse();
        response.setDescription("SUCCESS");
        response.setErrorcode(0);
        return response;
    }

    /**
     * 手环位置心率数据根据手环ID实时查询
     */
    @PostMapping("/shouhuan_getHrInfo")
    @ResponseBody
    public UnifyResponse getHrInfo(@RequestBody UnifyRequest<ReqIdList> request)
    {
        ReqIdList idList = request.getParams();
        System.out.println(JsonMapper.toJson(idList));

        UnifyResponse<JSONArray> response = new UnifyResponse();
        response.setDescription("SUCCESS");
        response.setErrorcode(0);

        JSONArray ja = new JSONArray();
        BraceletInfo bs1 = new BraceletInfo();
        bs1.setRecord_time("2018-11-22 01:56:45");
        bs1.setLon("114.034833");
        bs1.setLat("22.539651");
        bs1.setDevid("10000");
        bs1.setAt("0");
        bs1.setHr("0");
        ja.add(bs1);
        response.setResult(ja);
        return response;
    }

    /**
     * 手环位置心率数据根据中心点半径实时查询
     */
    @PostMapping("/shouhuan_getPositionInfo")
    @ResponseBody
    public UnifyResponse getPositionInfo(@RequestBody UnifyRequest<ReqPositionInfo> request)
    {
        ReqPositionInfo req = request.getParams();
        System.out.println(JsonMapper.toJson(req));

        UnifyResponse<JSONArray> response = new UnifyResponse();
        response.setDescription("SUCCESS");
        response.setErrorcode(0);

        JSONArray ja = new JSONArray();
        BraceletInfo bs1 = new BraceletInfo();
        bs1.setRecord_time("2018-11-22 01:56:45");
        bs1.setLon("114.034833");
        bs1.setLat("22.539651");
        bs1.setDevid("10000");
        bs1.setAt("0");
        bs1.setHr("0");
        ja.add(bs1);
        response.setResult(ja);
        return response;
    }

    /**
     * 手环告警事件阈值设置
     */
    @PostMapping("/shouhuan_setWarningInfo")
    @ResponseBody
    public UnifyResponse setWarningInfo(@RequestBody UnifyRequest<ReqWarningInfo> request)
    {
        ReqWarningInfo req = request.getParams();
        System.out.println(JsonMapper.toJson(req));

        UnifyResponse<JSONArray> response = new UnifyResponse();
        response.setDescription("SUCCESS");
        response.setErrorcode(0);
        return response;
    }

    /**
     * 手环推送信息
     */
    @PostMapping("/shouhuan_getInfo")
    @ResponseBody
    public RespGetInfo getInfo(@RequestBody(required = false) UnifyRequest request)
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
}
