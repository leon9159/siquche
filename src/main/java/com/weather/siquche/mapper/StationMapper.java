package com.weather.siquche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weather.siquche.povo.po.Station;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StationMapper extends BaseMapper<Station> {
}
