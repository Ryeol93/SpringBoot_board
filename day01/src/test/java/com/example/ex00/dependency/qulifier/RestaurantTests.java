package com.example.ex00.dependency.qulifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTests {

    @Autowired
    @Qualifier("outback")
    private Restaurant outback;

    @Autowired
    @Qualifier("vips")
    private Restaurant vips;

    @Autowired
    private Restaurant restaurant;

    @Test
    public void RestaurantTests() {
        log.info("------------------------------------");
        log.info("outback : " + outback.getSteakPrice());
        log.info("outback : " + outback.getSidebar());
        log.info("vips : " + vips.getSteakPrice());
        log.info("vips : " + vips.getSidebar());
        log.info("restaurant : " + restaurant.getSteakPrice());
        log.info("restaurant : " + restaurant.getSidebar());
        log.info("------------------------------------");
    }
}
