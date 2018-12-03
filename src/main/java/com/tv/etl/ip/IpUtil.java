package com.tv.etl.ip;

import com.github.jarod.qqwry.IPZone;
import com.github.jarod.qqwry.QQWry;

import java.io.IOException;

public class IpUtil {

    /**
     * 封装ip解析出来的信息
     * @param ip
     */
    public static  void getCity(String ip){

        try {
            QQWry qqwry = new QQWry();
            IPZone zone = qqwry.findIP(ip);
            System.out.println(zone.getMainInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        getCity("10.9.181.90");
    }

}
