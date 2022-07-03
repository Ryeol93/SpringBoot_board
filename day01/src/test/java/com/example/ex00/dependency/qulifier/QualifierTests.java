package com.example.ex00.dependency.qulifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;

@SpringBootTest
@Slf4j
public class QualifierTests {
    @Autowired
    @Qualifier("desktop") 
    private Computer desktop;

    @Autowired
    @Qualifier("laptop")
    private Computer laptop;

    @Autowired
    private Computer computer;

    @Test
    public void qualifierTest(){
        log.info("------------------------------");
        log.info("desktop : " + desktop.getScreenWidth());
        log.info("laptop : " + laptop.getScreenWidth());
        log.info("computer : " + computer.getScreenWidth());
        log.info("------------------------------");
    }
}
