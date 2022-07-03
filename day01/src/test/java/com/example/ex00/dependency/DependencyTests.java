package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 단위테스트 환경으로 만들어줌
@Slf4j // 로그 출력 라이브러리
public class DependencyTests {
    @Autowired // 필드주입 알아서 해줌
    private Coding coding;

    @Test  // 테스트용
    public void checkDI(){
        log.info("------------------------------");
        log.info("coding : " + coding);
        log.info("computer : " + coding.getComputer());
        log.info("------------------------------");
    }
}
