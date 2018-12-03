package com.tv.etl;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class UserAgentUtil {

private final static Logger logger= Logger.getLogger(String.valueOf(UserAgentUtil.class));
private static UASparser uaSparser = null;
static {

    try {
        uaSparser = new UASparser(OnlineUpdater.getVendoredInputStream());
    } catch (IOException e) {
        logger.warning("初始化userAgent异常");
        e.printStackTrace();
    }

}

public static UserAgentInfo parserUserAgent(String userAgent){
    try {
        UserAgentInfo info = null;
        //判断是否为空
        if (StringUtils.isEmpty(userAgent)){
            return info;
        }

        //userAgnet肯定不为空
        cz.mallat.uasparser.UserAgentInfo uinfo = uaSparser.parse(userAgent);

        if (uinfo!=null){
            info = new UserAgentInfo();
            info.setBrowserName(uinfo.getUaFamily());
            info.setBrowserVersion(uinfo.getBrowserVersionInfo());
            info.setOsName(uinfo.getOsFamily());
            info.setOsVersion(uinfo.getOsName());
        }
        return info;
    } catch (IOException e) {
        logger.warning("解析异常");
        e.printStackTrace();
    }
    return null;
}

    /**
     * 用于封装useragent被解析后的信息
     */

    public static class UserAgentInfo{

        private String browserName;
        private String browserVersion;
        private String osName;
        private String osVersion;

        public String getBrowserName() {
            return browserName;
        }

        public void setBrowserName(String browserName) {
            this.browserName = browserName;
        }

        public String getBrowserVersion() {
            return browserVersion;
        }

        public void setBrowserVersion(String browserVersion) {
            this.browserVersion = browserVersion;
        }

        public String getOsName() {
            return osName;
        }

        public void setOsName(String osName) {
            this.osName = osName;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {

            this.osVersion = osVersion;
        }

        @Override
        public String toString() {
            return "UserAgentInfo{" +
                    "browserName='" + browserName + '\t' +
                    ", browserVersion='" + browserVersion + '\t' +
                    ", osName='" + osName + '\t' +
                    ", osVersion='" + osVersion + '\t' +
                    '}';
        }
    }
}
