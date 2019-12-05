package com.weather.siquche.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weather.siquche.mapper.StationMapper;
import com.weather.siquche.povo.po.Station;
import com.weather.siquche.service.IStationService;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements IStationService {
}
