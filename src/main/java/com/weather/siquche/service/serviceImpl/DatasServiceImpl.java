package com.weather.siquche.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weather.siquche.mapper.DatasMapper;
import com.weather.siquche.povo.po.Datas;
import com.weather.siquche.povo.vo.LargeVO;
import com.weather.siquche.povo.vo.TableVO;
import com.weather.siquche.povo.vo.TimeVO;
import com.weather.siquche.service.IDatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatasServiceImpl extends ServiceImpl<DatasMapper, Datas> implements IDatasService {
    @Autowired
    private DatasMapper datasMapper;

    public Object getTable(TimeVO timeVO){
        QueryWrapper<Datas> qw = new QueryWrapper<>();
        Integer year = timeVO.getDate().getYear();
        Integer month = timeVO.getDate().getMonthValue();
        Integer day = timeVO.getDate().getDayOfMonth();
        qw.eq("year",year).eq("month",month).eq("day",day);
        List<Datas> ls = datasMapper.selectList(qw);
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

   public Object getLarge(){
        QueryWrapper<Datas> qw = new QueryWrapper<>();
        qw.select("PM25","PM10","SO2","NO2","CO","O3");
        List<Datas> ls = datasMapper.selectList(qw);
        LargeVO largeVO = new LargeVO();
        largeVO.setPm25(ls.stream().map(datas -> datas.getPM25())
                .collect(Collectors.toList()));
        largeVO.setPm10(ls.stream().map(datas -> datas.getPM10())
               .collect(Collectors.toList()));
        largeVO.setSo2(ls.stream().map(datas -> datas.getSO2())
               .collect(Collectors.toList()));
        largeVO.setNo2(ls.stream().map(datas -> datas.getNO2())
               .collect(Collectors.toList()));
        largeVO.setCo(ls.stream().map(datas -> datas.getCO())
               .collect(Collectors.toList()));
        largeVO.setO3(ls.stream().map(datas -> datas.getO3())
               .collect(Collectors.toList()));
        return largeVO;

    }



}
