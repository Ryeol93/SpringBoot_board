package com.example.board.controller;


import com.example.board.BoardApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;

//JUnit5
@ExtendWith(SpringExtension.class) //  컨트롤러는  5버전 부터 가능 4버전에서 5버전으로 올린다.
@SpringBootTest(classes = {BoardApplication.class}) // 버전 업그레이드시 해야하는 설정
@Slf4j
public class BoardControllerTests {

    // 가짜 MVC
    // 마치 브라우저에서 URL을 요청한 것처럼 환경을 만들어준다 .
    private MockMvc mockMvc; // 단위테스트를 위한 객체

    // 사용자의 요청을 처리해주는 WebApplicationContext를 불러온다.
    @Autowired
    private WebApplicationContext webApplicationContext; // 직접 관리하기 위해 가져옴

    @BeforeEach // 각각 메소드마다 셋업이 먼저 실행 될 수 있게
    //  미리 셋업을 만든다
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testRead() throws Exception{
        String checkRead = mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
                .param("bno",String.valueOf(2L))).andReturn().getModelAndView().getView();
        log.info(checkRead);
    }

    @Test
    public void testRemove() throws Exception{

    }

//    @Test
//    public void testRegister() throws Exception {
//        String checkBno = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//                .param("title","테스트 새글 제목")
//                .param("content", "테스트 새글 내용")
//                .param("writer", "hds1234")
//        ).andReturn().getFlashMap().toString();
//
//        log.info(checkBno);
//    }

//    @Test
//    public void testList() throws  Exception{
//        // perform(method방식()) : 해당 요청을 전달해주는 메소드
//        // get("URL") : get method 방식으로 해당 URL 요청
//        // post("URL") : post method 방식으로 해당 URL 요청
//        // andReturn() : 요청 결과 객체 가져오기
//        // getModelAndView() : 화면의 경로 또는 Model 데이터 전달자의 파라미터 확인
//        // getModelMap(): Model 데이터 전달자에 추가해놓은 파라미터를 Map 구조로 확인 가능
//
//
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModel().toString()); // 요청할 URL
//        // 모델 전달자의 파라미터 확인
//
//        // post 방식이라면 get을 post로 변경
//    }




}