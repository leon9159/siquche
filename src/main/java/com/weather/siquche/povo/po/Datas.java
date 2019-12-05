package com.weather.siquche.povo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_data")
public class Datas {
    @TableId
    private Integer No;
    private Integer year;
    private Integer month;
    private Integer day;
    @TableField(value = "hour")
    private Integer hour;
    @TableField(value = "PM25")
    private Double PM25;
    @TableField(value = "PM10")
    private Double PM10;
    @TableField(value = "SO2")
    private Double SO2;
    @TableField(value = "NO2")
    private Double NO2;
    @TableField(value = "CO")
    private Double CO;
    private Double O3;
    private String temp;
    private String dewp;
    private Integer rain;
    private String wd;
    private Double wspm;
    @TableField(value = "station")
    private String stationName;

}
