package com.weather.siquche.povo.vo;

import lombok.Data;

import java.util.List;

@Data
public class ForecastVO {
    private List<Double> aqi;
    private List<Double> aqiReal;
    private List<String> date;
}
