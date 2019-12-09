package com.weather.siquche.util;

import java.util.List;

public class Util {
    public static Double avg(List<Double> ls){
        int i = 0;
        Double sum = 0.00;
        for(i = 0;i<ls.size();i++){
            sum = sum+ ls.get(i);
        }
        Double avgNum = sum/i;
        return avgNum;
    }
}
