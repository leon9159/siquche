package com.weather.siquche;

import com.weather.siquche.mapper.StationMapper;
import com.weather.siquche.povo.po.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SiqucheApplicationTests {
    @Autowired
    private StationMapper stationMapper;
    @Test
    public void testSelect() {
        List<Station> ls = stationMapper.selectList(null);
        ls.forEach(System.out::println);
    }

}
