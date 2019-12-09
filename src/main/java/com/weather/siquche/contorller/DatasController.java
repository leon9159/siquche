package com.weather.siquche.contorller;

import com.weather.siquche.povo.vo.TimeVO;
import com.weather.siquche.service.serviceImpl.AverageServiceImpl;
import com.weather.siquche.service.serviceImpl.DatasServiceImpl;
import com.weather.siquche.service.serviceImpl.WeekServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/data")
@Api(tags = "表格")
public class DatasController {
    @Autowired
    private WeekServiceImpl weekService;
    @Autowired
    private AverageServiceImpl averageService;

    /**
     * 根据所选时间返回table中的数据
     * @param date
     * @return
     */
    @CrossOrigin
    @ApiOperation(value ="查询表中数据" )
    @PostMapping("/table")
    public Object getTableDatas(@RequestBody TimeVO date){
        return weekService.getTableData(date);
    }

    @CrossOrigin
    @ApiOperation(value = "大数据面积图")
    @GetMapping("/large")
    public Object getLarge(){
        return averageService.getLarge();
    }

}
