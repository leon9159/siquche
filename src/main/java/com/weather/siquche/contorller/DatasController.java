package com.weather.siquche.contorller;

import com.alibaba.druid.sql.visitor.functions.Isnull;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weather.siquche.povo.vo.HeatMapVO;
import com.weather.siquche.povo.vo.TimeVO;
import com.weather.siquche.service.serviceImpl.AverageServiceImpl;
import com.weather.siquche.service.serviceImpl.DayDataServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/data")
@Api(tags = "表格")
public class DatasController {
    @Autowired
    private AverageServiceImpl averageService;
    @Autowired
    private DayDataServiceImpl dayDataService;

    /**
     * 根据所选时间返回table中的数据
     * @param date
     * @return
     */
    @CrossOrigin
    @ApiOperation(value ="查询表中数据" )
    @PostMapping("/table")
    public Object getTableDatas(@RequestBody TimeVO date){
        if(date.getDate()==null){
            date.setDate(LocalDate.parse("2013-03-01"));
        }
        return dayDataService.getTableData(date);
    }

    @CrossOrigin
    @ApiOperation(value = "大数据面积图")
    @GetMapping("/large")
    public Object getLarge(){
        return averageService.getLarge();
    }

    @CrossOrigin
    @PostMapping("/heat")
    public Object getHeat(@RequestBody TimeVO timeVO){
        return dayDataService.getHeatData(timeVO);
    }

    @CrossOrigin
    @PostMapping("/heatmap")
    public Object getHeatMap(@RequestBody TimeVO timeVO){
        if(timeVO.getDate()==null){
            timeVO.setDate(LocalDate.parse("2013-03-01"));
        }
        return dayDataService.getHeatMap(timeVO);

    }

}
