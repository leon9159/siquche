package com.weather.siquche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weather.siquche.povo.po.WeekData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeekMapper extends BaseMapper<WeekData> {
}
