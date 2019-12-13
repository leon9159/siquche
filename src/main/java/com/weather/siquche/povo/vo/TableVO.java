package com.weather.siquche.povo.vo;

import lombok.Data;

@Data
public class TableVO {
    private String stationName;
    private Double PM25;
    private Double PM10;
    private Double SO2;
    private Double NO2;
    private Double CO;
    private Double O3;
    private Double aqi;
}
