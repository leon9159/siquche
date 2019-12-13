package com.weather.siquche.povo.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_station")
public class Station {
    @TableId
    private Integer stationId;
    private String stationName;
    private Double lng;
    private Double lat;
}
