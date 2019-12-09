package com.weather.siquche.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weather.siquche.mapper.WeekMapper;
import com.weather.siquche.povo.po.Datas;
import com.weather.siquche.povo.po.WeekData;
import com.weather.siquche.povo.vo.LargeVO;
import com.weather.siquche.povo.vo.TableVO;
import com.weather.siquche.povo.vo.TimeVO;
import com.weather.siquche.service.IWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeekServiceImpl extends ServiceImpl<WeekMapper, WeekData> implements IWeekService {
    @Autowired
    private WeekMapper weekMapper;

    public Object getTableData(TimeVO timeVO){
        QueryWrapper<WeekData> qw = new QueryWrapper<>();
        String date = timeVO.getDate().toString();
        qw.eq("date",date).orderByAsc("station_id");
        List<WeekData> ls = weekMapper.selectList(qw);
        if (ls.size()==0){
            return "空";
        }
        var TableVOS = ls.stream().map(datas -> {
            TableVO tableVO =new TableVO();
            tableVO.setStationName(datas.getStationName());
            tableVO.setPM25(datas.getPM25());
            tableVO.setPM10(datas.getPM10());
            tableVO.setCO(datas.getCO());
            tableVO.setNO2(datas.getNO2());
            tableVO.setO3(datas.getO3());
            tableVO.setSO2(datas.getSO2());
            return tableVO;
        });
        return TableVOS.collect(Collectors.toList());
    }


}
