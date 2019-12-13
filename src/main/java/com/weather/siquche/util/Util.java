package com.weather.siquche.util;

import java.text.DecimalFormat;
import java.time.LocalDate;
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
    public static String season(LocalDate date){
        Integer month = date.getMonthValue();
        if(month>=3&&month<=5){
            return "春";
        }else if(month>=6&&month<=8){
            return "夏";
        }else if(month>=9&&month<=11){
            return "秋";
        }
        return "冬";
    }

    public static Double doubleTwo(Double num){
        DecimalFormat df = new DecimalFormat("#.00");
        String nu = df.format(num);
        num = Double.valueOf(nu);
        return num;
    }
}
