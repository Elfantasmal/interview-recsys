package com.rrdssfgcs.interviewcheatsheet.linearregression;

import com.rrdssfgcs.interviewcheatsheet.utils.CsvtoMatrix.Matrix;
import com.rrdssfgcs.interviewcheatsheet.utils.CSVUtils;
import java.util.List;

public class NormalEquationPredictor {
    public static void main(String[] args){
       /**
       读入数据，并构建相应的训练参数数组：
       * featuresTrain
       * valuesTrain
       构建测试参数：
       * featuresTest
        */
        String csvFilePath = "./data/X.csv";
        char spliter = ' ';
        List<List<Double>> featuresList = CSVUtils.readeCSV(csvFilePath, spliter);
        if (featuresList == null) {
            System.out.println("featuresList error");
            return;
        }

        int trainSizeRow=featuresList.size()-20;
        int trainSizeCol=2;
        double[][] featuresTrain = new double[trainSizeRow][trainSizeCol];
        for (int i = 0; i < trainSizeRow; i++) {
            featuresTrain[i][0] = 1.0;
            featuresTrain[i][1] = featuresList.get(i).get(2);
        }

        int testSizeRow=20;
        int testSizeCol=2;
        double[][] featuresTest = new double[testSizeRow][testSizeCol];
        for (int i =(featuresList.size()-20) ; i<featuresList.size(); i++) {
            featuresTest[i-(featuresList.size()-20)][0] = 1.0;
            featuresTest[i-(featuresList.size()-20)][1] = featuresList.get(i).get(2);
        }
        /*
        打印featuresTrain数组查看
        for (int i = 0; i < featuresTrain.length; i++) {
            for (int j = 0; j < featuresTrain[i].length; j++) {
                System.out.println(featuresTrain[i][j]);
            }
        }
        */

        csvFilePath = "./data/y.csv";
        List<List<Double>> valuesList = CSVUtils.readeCSV(csvFilePath, spliter);

        if (valuesList == null) {
            System.out.println("valuesList error");
            return;
        }
        int valuesTrainSizeRow=valuesList.size()-20;
        int valuesTrainSizeCol=1;
        double[][] valuesTrain = new double[valuesTrainSizeRow][valuesTrainSizeCol];
        for (int i = 0; i < valuesTrainSizeRow; i++) {
            valuesTrain[i][0] = valuesList.get(i).get(0);
        }
        /*
        double[][] valuesTest = new double[20][1];
        for (int i = valuesList.size()-20; i < valuesList.size(); i++) {
            valuesTest[i-422][0] = valuesList.get(i).get(0);
        }
        */
        /*
        打印valuesTrain数组
        for (int i = 0; i < valuesTrain.length; i++) {
            for (int j = 0; j < valuesTrain[i].length; j++) {
                System.out.println(valuesTrain[i][j]);
            }
        }
        */
        /**
         * 构建相应的训练和测试矩阵，计算线性回归的关键参数w，并调用predictor方法进行预测。
         */
        Matrix featuresTrainMatrix = new Matrix(featuresTrain);
        Matrix valuesTrainMatrix = new Matrix(valuesTrain);
        Matrix featuresTestMatrix = new Matrix(featuresTest);
        Matrix w = normalEquation(featuresTrainMatrix, valuesTrainMatrix);
        Matrix predictorValues=predictor(w,featuresTestMatrix);
        double[][] predValues=predictorValues.getArrayCopy();
        /*
        打印predValues数组
         */
        System.out.println("predValues");
        for (int i = 0; i < predValues.length; i++) {
            for (int j = 0; j < predValues[i].length; j++) {
                System.out.println(i+"  "+predValues[i][j]);
            }
        }
    }

    public static Matrix normalEquation(Matrix features, Matrix values) {
        Matrix featuresTranspose=features.transpose();
        Matrix featuresTransposeTimeFeatures = featuresTranspose.times(features);
        Matrix pseudoinverse=featuresTransposeTimeFeatures.inverse();
        Matrix featuresTransposeTimeValues = featuresTranspose.times(values);
        Matrix w = pseudoinverse.times(featuresTransposeTimeValues);
        return w;
    }

    public static Matrix predictor(Matrix w, Matrix featuresTest) {
        Matrix predictorValues = featuresTest.times(w);
        return predictorValues;
    }
}
