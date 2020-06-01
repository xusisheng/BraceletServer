package com.aw.bracelet.huawei.subscribe;

import com.aw.bracelet.huawei.SubCallbackStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintOnlineUsersCommand implements SubCallbackStrategy {
    private static final Logger logger = LoggerFactory.getLogger(PrintOnlineUsersCommand.class);

    @Override
    public void process(String msg) {
        try {
            logger.debug("================");
        } catch (Exception e) {
            logger.error("Exception", e);
        }
    }
}
