package com.weather.siquche.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weather.siquche.mapper.AverageMapper;
import com.weather.siquche.povo.po.AverageData;
import com.weather.siquche.povo.vo.LargeVO;
import com.weather.siquche.service.IAverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AverageServiceImpl extends ServiceImpl<AverageMapper, AverageData> implements IAverageService {
    @Autowired
    private AverageMapper averageMapper;
    public Object getLarge(){
        QueryWrapper<AverageData> qw = new QueryWrapper<>();
        qw.select("pm25","pm10","so2","no2","co","o3");
        List<AverageData> ls = averageMapper.selectList(qw);
        LargeVO largeVO = new LargeVO();
        largeVO.setPm25(ls.stream().map(datas ->datas.getPm25())
                .collect(Collectors.toList()));
        largeVO.setPm10(ls.stream().map(datas -> datas.getPm10())
                .collect(Collectors.toList()));
        largeVO.setSo2(ls.stream().map(datas -> datas.getSo2())
                .collect(Collectors.toList()));
        largeVO.setNo2(ls.stream().map(datas -> datas.getNo2())
                .collect(Collectors.toList()));
        largeVO.setCo(ls.stream().map(datas -> datas.getCo())
                .collect(Collectors.toList()));
        largeVO.setO3(ls.stream().map(datas -> datas.getO3())
                .collect(Collectors.toList()));
        return largeVO;
    }
}
