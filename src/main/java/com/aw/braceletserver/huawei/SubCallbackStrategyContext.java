package com.aw.braceletserver.huawei;

import com.aw.braceletserver.utils.SpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SubCallbackStrategyContext {
    private final static Logger logger = LoggerFactory.getLogger(SubCallbackStrategyContext.class);

    /**
     * 获取执行器实例
     *
     * @param command 执行器实例
     * @return
     */
    public SubCallbackStrategy getInstance(String command) {
        Map<String, String> allClazz = SubCallbackTypeEnum.getAllClazz();
        String[] trim = command.trim().split(" ");
        String clazz = allClazz.get(trim[0]);
        SubCallbackStrategy strategy = null;
        try {
            strategy = (SubCallbackStrategy) SpringBeanFactory.getBean(Class.forName(clazz));
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return strategy;
    }
}
