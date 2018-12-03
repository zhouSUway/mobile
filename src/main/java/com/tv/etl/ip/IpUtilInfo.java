package com.tv.etl.ip;

import org.apache.commons.lang.StringUtils;

public class IpUtilInfo {


    public static class RegionInfo {
        private String DEFAULT_VALUE = "unknow";
        private String country;
        private String province;
        private String city;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDEFAULT_VALUE() {
            return DEFAULT_VALUE;
        }

        public void setDEFAULT_VALUE(String DEFAULT_VALUE) {
            this.DEFAULT_VALUE = DEFAULT_VALUE;
        }

        @Override
        public String toString() {
            return "RegionInfo{" +
                    "country='" + country + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }


        /**
         * ip解析来的信息
         */

        public static RegionInfo parseIp(String ip) {
            if (StringUtils.isEmpty(ip)) {

            }
            return null;
        }

    }
}
