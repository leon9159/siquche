package com.weather.siquche.povo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_pr")
@Data
public class Forecast {
    private Integer id;
    private Double aqi;
    @TableField("aqi_real")
    private Double aqiReal;
    private String date;
}
