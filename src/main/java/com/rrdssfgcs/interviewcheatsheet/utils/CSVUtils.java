package com.rrdssfgcs.interviewcheatsheet.utils;

import com.csvreader.CsvReader;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV工具类
 *
 * @author parker
 * @time 2017-12-09 11:38
 **/
public class CSVUtils {
    /**
     * 读取CSV文件
     */
    public static List<List<Double>> readeCSV(String csvFilePath, char spliter) {
        if (StringUtils.isEmpty(csvFilePath)) {
            return null;
        }
        CsvReader reader = null;
        List<List<Double>> featuresList = new ArrayList<>();
        try {
            reader = new CsvReader(csvFilePath, spliter, Charset.forName("SJIS"));
            while (reader.readRecord()) {
                String[] values = reader.getValues();
                if (values != null) {
                    List<Double> feature = new ArrayList<>();
                    for (String value : values) {
                        feature.add(Double.valueOf(value));
                    }
                    featuresList.add(feature);
                }
            }
            reader.close();
            return featuresList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
