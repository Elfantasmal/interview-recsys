package com.rrdssfgcs.interviewcheatsheet.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 配置文件工具类
 *
 * @author parker
 * @time 2017-10-05 16:36
 **/
public class ConfigUtil {

    private static final String confFile = "./conf/conf.properties";
    private static Configurations configs = new Configurations();
    private static Configuration config = new PropertiesConfiguration();

    static {
        update();
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 60L * 1000L, 60L * 1000L);
    }


    private static void update() {
        try {
            config = configs.properties(confFile);
            // access configuration properties
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static Configuration getConf() {
        return config;
    }


    public static String getNowcoderSpiderUrl() {
        return config.getString("spider.url.nowcoder");
    }
}
