package com.weather.siquche;

import com.weather.siquche.mapper.StationMapper;
import com.weather.siquche.povo.po.Station;
import com.weather.siquche.service.serviceImpl.DatasServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SiqucheApplicationTests {
    @Autowired
    private DatasServiceImpl datasService;
    @Test
    public void testSelect() {
        var ls = datasService.getLarge();
        System.out.println(ls);
    }

}
