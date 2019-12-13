package com.weather.siquche.povo.vo;

import lombok.Data;

@Data
public class HeatVO {
    private Integer stationId;
    private String stationName;
    private Double lng;
    private Double lat;
    private Double AQI;
}
