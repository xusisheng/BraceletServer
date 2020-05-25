package com.aw.braceletserver.service;

import com.aw.braceletserver.entity.IotAccessToken;
import com.aw.braceletserver.huawei.utils.Constant;
import com.aw.braceletserver.huawei.utils.HttpsUtil;
import com.aw.braceletserver.huawei.utils.StreamClosedHttpResponse;
import com.aw.braceletserver.utils.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class IotTokenService {
    private Logger logger = LoggerFactory.getLogger(IotTokenService.class);

    private static IotAccessToken token = new IotAccessToken();

//    @Scheduled(cron="* * * * * ?")
//    @PostConstruct  //系统启动时立即执行一次
    // 大概50分钟获取1次token，单位:ms
    @Scheduled(fixedRate = 1000*50)
    private void getIotToken() throws Exception {
        logger.info("--启动定时获取IoT平台令牌任务--");
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> param = new HashMap<>();
        param.put("appId", appId);
        param.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, param);
        System.out.println("app auth success,return accessToken:");
        System.out.println(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        Map<String, String> data = new HashMap<>();
        data = JsonMapper.toObject(responseLogin.getContent(), data.getClass());
        token.setAccessToken(data.get("accessToken"));
//        token.setExpiresIn(Integer.valueOf(data.get("expiresIn")));
        token.setRefreshToken(data.get("refreshToken"));
        token.setScope(data.get("scope"));
        token.setTokenType(data.get("tokenType"));
    }

    public static IotAccessToken getToken() {
        synchronized (token) {
            return token;
        }
    }
}
