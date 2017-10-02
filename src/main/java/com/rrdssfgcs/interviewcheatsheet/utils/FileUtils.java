package com.rrdssfgcs.interviewcheatsheet.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件工具类
 *
 * @author parker
 * @time 2017-10-02 22:04
 **/
public class FileUtils {
    public static void saveStringToFile(String string, String path) {
        if (StringUtils.isBlank(string) || StringUtils.isBlank(path)) {
            return;
        }

        try {
            File newTextFile = new File(path);
            FileWriter writer = new FileWriter(newTextFile);
            writer.write(string);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
