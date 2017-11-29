package com.rrdssfgcs.interviewcheatsheet.linearregression;
import Jama.Matrix;



public class NormalEquationPredictor {
    public static void main(String[] args){
        /*TODO定义一个训练输入features，定义相应的values；
       还有测试features；
        */
        Matrix wT=normalEquation(features,values);
        Matrix predictorValues=predictor(wt,testFeatures);
        System.out.println(predictorValues);
    }
    Matrix normalEquation(Matrix features,Matrix values){
        Matrix featuresTranspose=features.transpose();
        Matrix featuresTransposeTimeFeatures=featuresTranspose.times(Matrix features);
        Matrix pseudoinverse=featuresTransposeTimeFeatures.inverse();
        Matrix featuresTransposeTimeValues=featuresTranspose.times(Matrix values);
        Matrix w=pseudoinverse.times(Matrix featuresTransposeTimeValues);
        Matrix wTranspose=w.inverse();
        return wTranspose;
    }
    Matrix predictor(Matrix wT,Matrix testFeatures){
        Matrix predictorValues=wT.times(Matrix testFeatures);
        return predictorValues;
    }
}
