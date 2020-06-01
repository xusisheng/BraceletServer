package com.aw.bracelet.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "oviphone.api-uri")
public class ApiUri {
    private String domain;
    private String equimentInfo;
    private String healthInfo;
    private String login;
    private String sendCmd;
    private String historyTrack;
    private String historyWarnmsg;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEquimentInfo() {
        return equimentInfo;
    }

    public void setEquimentInfo(String equimentInfo) {
        this.equimentInfo = equimentInfo;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSendCmd() {
        return sendCmd;
    }

    public void setSendCmd(String sendCmd) {
        this.sendCmd = sendCmd;
    }

    public String getHistoryTrack() {
        return historyTrack;
    }

    public void setHistoryTrack(String historyTrack) {
        this.historyTrack = historyTrack;
    }

    public String getHistoryWarnmsg() {
        return historyWarnmsg;
    }

    public void setHistoryWarnmsg(String historyWarnmsg) {
        this.historyWarnmsg = historyWarnmsg;
    }
}
