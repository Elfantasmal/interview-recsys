package com.rrdssfgcs.interviewcheatsheet.linearregression;

import Jama.Matrix;
import com.rrdssfgcs.interviewcheatsheet.utils.CSVUtils;

import java.util.List;

public class NormalEquationPredictor {
    public static void main(String[] args){
        /*TODO定义一个训练输入features，定义相应的values；
       还有测试features；
        */
        String csvFilePath = "./data/X.csv";
        char spliter = ' ';
        List<List<Double>> featuresList = CSVUtils.readeCSV(csvFilePath, spliter);
        if (featuresList == null) {
            System.out.println("featuresList error");
            return;
        }
        double[][] features = new double[featuresList.size()][1];
        for (int i = 0; i < featuresList.size(); i++) {
            features[i][0] = featuresList.get(i).get(0);
        }
        csvFilePath = "./data/y.csv";
        List<List<Double>> valuesList = CSVUtils.readeCSV(csvFilePath, spliter);
        if (valuesList == null) {
            System.out.println("valuesList error");
            return;
        }
        double[][] values = new double[valuesList.size()][1];
        for (int i = 0; i < valuesList.size(); i++) {
            values[i][0] = valuesList.get(i).get(0);
        }

        Matrix featuresMatrix = new Matrix(features);
        Matrix valuesMatrix = new Matrix(values);

        Matrix wT = normalEquation(featuresMatrix, valuesMatrix);

//        Matrix predictorValues=predictor(wt,testFeatures);
//        System.out.println(predictorValues);
    }

    public static Matrix normalEquation(Matrix features, Matrix values) {
        Matrix featuresTranspose=features.transpose();
        Matrix featuresTransposeTimeFeatures = featuresTranspose.times(features);
        Matrix pseudoinverse=featuresTransposeTimeFeatures.inverse();
        Matrix featuresTransposeTimeValues = featuresTranspose.times(values);
        Matrix w = pseudoinverse.times(featuresTransposeTimeValues);
        Matrix wTranspose=w.inverse();
        return wTranspose;
    }

    public static Matrix predictor(Matrix wT, Matrix testFeatures) {
        Matrix predictorValues = wT.times(testFeatures);
        return predictorValues;
    }
}
