package com.weather.siquche.povo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("t_week")
@Data
public class WeekData {
    @TableId
    private Integer id;
    private Integer No;
    private Integer year;
    private Integer month;
    private Integer day;
    private String date;
    private String week;
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
    private Double temp;
    private Double dewp;
    private Double PRES;
    private Double rain;
    private Double wd;
    private Double wspm;
    @TableField(value = "station")
    private String stationName;
    @TableField(value = "station_id")
    private Integer stationId;
}
