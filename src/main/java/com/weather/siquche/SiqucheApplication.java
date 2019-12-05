package com.weather.siquche;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.weather.siquche.mapper")
public class SiqucheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiqucheApplication.class, args);
    }

}
