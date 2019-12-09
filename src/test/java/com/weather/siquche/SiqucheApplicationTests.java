package com.weather.siquche;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weather.siquche.mapper.AverageMapper;
import com.weather.siquche.mapper.WeekMapper;
import com.weather.siquche.povo.po.AverageData;
import com.weather.siquche.povo.po.WeekData;
import com.weather.siquche.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SpringBootTest
class SiqucheApplicationTests {
    @Autowired
    private WeekMapper weekMapper;
    @Autowired
    private AverageMapper averageMapper;
    @Test
    public void processData() {
        QueryWrapper<AverageData> qw = new QueryWrapper<>();
        List<String> date = averageMapper.selectList(qw.select("date"))
                .stream().map(data-> {return data.getDate();})
                .collect(Collectors.toList());
        QueryWrapper<WeekData> queryWrapper = null;
        Map<String,Double> map = new HashMap<>();
        for(int i=0;i<date.size();i++){
            queryWrapper = new QueryWrapper<>();
            List<AverageData> average = weekMapper.selectList(queryWrapper.select("pm25","pm10","so2","no2","co","o3").eq("date",date.get(i)))
                    .stream().map(data->{
                        AverageData averageData = new AverageData();
                        averageData.setPm25(data.getPM25());
                        averageData.setPm10(data.getPM10());
                        averageData.setSo2(data.getSO2());
                        averageData.setNo2(data.getNO2());
                        averageData.setCo(data.getCO());
                        averageData.setO3(data.getO3());
                        return averageData;
                    })
                    .collect(Collectors.toList());
            AverageData averageData = new AverageData();
            averageData.setDate(date.get(i));
            Double pm25avg = 0.00;
            Double pm10avg = 0.00;
            Double so2avg = 0.00;
            Double no2avg = 0.00;
            Double coavg = 0.00;
            Double o3avg = 0.00;
            int j=0;
            for(j=0; j<average.size();j++){
                pm25avg = average.get(j).getPm25()+pm25avg;
                pm10avg = average.get(j).getPm10()+pm10avg;
                so2avg = average.get(j).getSo2()+so2avg;
                no2avg = average.get(j).getNo2()+no2avg;
                coavg = average.get(j).getCo()+coavg;
                o3avg = average.get(j).getO3()+o3avg;
            }
            averageData.setPm25(pm25avg/j);
            averageData.setPm10(pm10avg/j);
            averageData.setSo2(so2avg/j);
            averageData.setNo2(no2avg/j);
            averageData.setCo(coavg/j);
            averageData.setO3(o3avg/j);
            QueryWrapper<AverageData> upqw = new QueryWrapper<>();
            upqw.eq("date",date.get(i));
            averageMapper.update(averageData,upqw);
        }
    }

}
