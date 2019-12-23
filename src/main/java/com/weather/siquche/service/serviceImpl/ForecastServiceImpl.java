package com.weather.siquche.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weather.siquche.mapper.ForecastMapper;
import com.weather.siquche.povo.po.Forecast;
import com.weather.siquche.povo.vo.ForecastVO;
import com.weather.siquche.service.IForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForecastServiceImpl extends ServiceImpl<ForecastMapper, Forecast> implements IForecastService {

    @Autowired
    private ForecastMapper forecastMapper;
    public Object getForecastData(){
        QueryWrapper<Forecast> qw = new QueryWrapper<>();
        qw.select("date","aqi","aqi_real");
        List<Forecast> ls = forecastMapper.selectList(qw);
        ForecastVO forecastVO = new ForecastVO();
        forecastVO.setAqi(ls.stream().map(datas ->datas.getAqi())
                .collect(Collectors.toList()));
        forecastVO.setAqiReal(ls.stream().map(datas ->datas.getAqiReal())
                .collect(Collectors.toList()));
        forecastVO.setDate(ls.stream().map(datas ->datas.getDate())
                .collect(Collectors.toList()));
        return forecastVO;
    }
}
