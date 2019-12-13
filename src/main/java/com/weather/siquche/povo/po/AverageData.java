package com.weather.siquche.povo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_average")
public class AverageData {
    private Integer id;
    private Double pm25;
    private Double pm10;
    private Double so2;
    private Double no2;
    private Double co;
    private Double o3;
    private String date;
    private Double aqi;
    private String week;
}
