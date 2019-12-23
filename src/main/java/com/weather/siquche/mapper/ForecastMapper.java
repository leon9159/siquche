package com.weather.siquche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weather.siquche.povo.po.Forecast;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastMapper extends BaseMapper<Forecast> {
}
