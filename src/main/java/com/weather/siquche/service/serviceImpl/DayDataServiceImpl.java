package com.weather.siquche.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weather.siquche.mapper.AverageMapper;
import com.weather.siquche.mapper.DayDataMapper;
import com.weather.siquche.mapper.StationMapper;
import com.weather.siquche.povo.po.AverageData;
import com.weather.siquche.povo.po.DayData;
import com.weather.siquche.povo.po.Station;
import com.weather.siquche.povo.vo.HeatMapVO;
import com.weather.siquche.povo.vo.HeatVO;
import com.weather.siquche.povo.vo.TableVO;
import com.weather.siquche.povo.vo.TimeVO;
import com.weather.siquche.service.IDayDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayDataServiceImpl extends ServiceImpl<DayDataMapper, DayData> implements IDayDataService {
    @Autowired
    private DayDataMapper dayDataMapper;
    @Autowired
    private StationMapper stationMapper;

    /**
     * 获取表格中的数据
     * @param timeVO
     * @return
     */
    public Object getTableData(TimeVO timeVO){
        QueryWrapper<DayData> qw = new QueryWrapper<>();
        String date = timeVO.getDate().toString();
        qw.eq("date",date).orderByAsc("station_id");
        List<DayData> ls = dayDataMapper.selectList(qw);
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
            tableVO.setAqi(datas.getAqi());
            return tableVO;
        });
        return TableVOS.collect(Collectors.toList());
    }

    /**
     * 获取各观测站名称、Id、经纬度、AQI数值
     * @param timeVO
     * @return
     */
    public List<HeatVO> getHeatData(TimeVO timeVO){
        String date = timeVO.getDate().toString();
        QueryWrapper<Station> qwStation = new QueryWrapper<>();
        qwStation.orderByAsc("station_id");
        List<Station> stations = stationMapper.selectList(qwStation);
        List<HeatVO> heatVOS = stations.stream().map(station -> {
                HeatVO heatvo = new HeatVO();
                heatvo.setStationName(station.getStationName());
                heatvo.setStationId(station.getStationId());
                heatvo.setLng(station.getLng());
                heatvo.setLat(station.getLat());
                return heatvo;
        }).collect(Collectors.toList());
        QueryWrapper<DayData> qwDay = new QueryWrapper<>();
        qwDay.select("station_id","AQI").eq("date",date).orderByAsc("station_id");
        List<DayData> dayData = dayDataMapper.selectList(qwDay);
        for(int i=0;i<heatVOS.size();i++){
            heatVOS.get(i).setAQI(dayData.get(i).getAqi());
        }
        return heatVOS;
    }

    /**
     * 获取各观测站经纬度、AQI数值
     * @param timeVO
     * @return
     */
    public List<HeatMapVO> getHeatMap(TimeVO timeVO){
        List<HeatVO> datas = getHeatData(timeVO);
        List<HeatMapVO> heatMapVOS = datas.stream().map(heatVO -> {
            HeatMapVO heatMapVO = new HeatMapVO();
            heatMapVO.setLng(heatVO.getLng());
            heatMapVO.setLat(heatVO.getLat());
            heatMapVO.setCount(heatVO.getAQI());
            return heatMapVO;
        }).collect(Collectors.toList());
        return heatMapVOS;
    }

}
