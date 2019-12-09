package com.weather.siquche.povo.vo;

import lombok.Data;

import java.util.List;

@Data
public class LargeVO {
    private List<Double> pm25;
    private List<Double> pm10;
    private List<Double> so2;
    private List<Double> no2;
    private List<Double> co;
    private List<Double> o3;
    private List<Double> AQI;
}
