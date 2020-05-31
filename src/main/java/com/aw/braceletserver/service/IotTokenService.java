package com.aw.braceletserver.service;

import com.aw.braceletserver.entity.IotAccessToken;
import com.aw.braceletserver.huawei.utils.Constant;
import com.aw.braceletserver.huawei.utils.HttpsUtil;
import com.aw.braceletserver.huawei.utils.StreamClosedHttpResponse;
import com.aw.braceletserver.utils.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IotTokenService {
    private static Logger logger = LoggerFactory.getLogger(IotTokenService.class);

    private static IotAccessToken token = new IotAccessToken();

//    @Scheduled(cron="* * * * * ?")
//    @PostConstruct  //系统启动时立即执行一次
    // 大概50分钟获取1次token，单位:ms
//    @Scheduled(fixedRate = 1000*50)
    private static void getIotToken() {
        logger.info("--启动定时获取IoT平台令牌任务--");
        HttpsUtil httpsUtil = new HttpsUtil();
        try {
            httpsUtil.initSSLConfigForTwoWay();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> param = new HashMap<>();
        param.put("appId", appId);
        param.put("secret", secret);

        StreamClosedHttpResponse responseLogin = null;
        try {
            responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, param);
            logger.debug(responseLogin.getStatusLine().toString());
            logger.debug(responseLogin.getContent());

            Map<String, String> data = new HashMap<>();
            data = JsonMapper.toObject(responseLogin.getContent(), data.getClass());
            token.setAccessToken(data.get("accessToken"));
            token.setRefreshToken(data.get("refreshToken"));
            token.setScope(data.get("scope"));
            token.setTokenType(data.get("tokenType"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static IotAccessToken getToken() {
        synchronized (token) {
            if (token.getAccessToken() == null) {
                IotTokenService.getIotToken();
            }
            return token;
        }
    }
}
