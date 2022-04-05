package com.example.ex02.controllers;

import com.example.ex02.domain.ExampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller // 스프링의 객체로 등록
@Slf4j
@RequestMapping("/ex/*") //현재 클래스 내에 모든 메소드들의 기본 경로 설정 (예: /ex/aaa, /ex/bbb 등)
public class ExampleController {

    @RequestMapping(value = "/example", method = {RequestMethod.GET, RequestMethod.POST})
    public void ex01(){
        log.info("ex01 get and post...........");
    }

    @RequestMapping(value = "/ex02", method = {RequestMethod.GET, RequestMethod.POST})
    public void ex02(HttpServletRequest request){
        log.info("ex02 " + request.getMethod().toLowerCase() + ".............");
    }

//    GET, POST 상관 없이 Controller 로직을 수행한다면 method 옵션을 사용하지 않는다.
//    value 속성 한 개만 사용할 때에는 아래와 같이 값만 전달한다.
    @RequestMapping("")
    public void ex03(){
        log.info("ex03.............");
    }

    @GetMapping("/ex04")
    public void ex04(){
        log.info("ex04 :: only get.............");
    }

    @GetMapping("/ex05")
//    전달받은 파라미터는 자동으로 매개변수의 객체와 mapping되어 주입된다.
//    리턴 타입이 void라면 요청한 URL의 경로로 html파일을 찾게 된다.
//    원하는 경로가 있다면 경로를 String으로 리턴한다.
    public void ex05(@ModelAttribute("exampleVO") ExampleVO exampleVO){
//        @ModelAttribute("KEY") 자료형 매개변수
//        매개변수에 전달된 파라미터를 화면쪽에서 KEY로 사용할 수 있게 된다.

        log.info("-----------------------------");
        log.info(exampleVO.toString());
        log.info("-----------------------------");
    }

    @GetMapping("/ex06")
//    매개변수자리에 클래스타입의 매개변수가 한 개 선언되어 있다면 앞글자만 소문자로 바뀐 값을
//    화면에서 KEY로 사용할 수 있다. 이 때에는 따로 Model 객체를 사용하지 않는다.
//    매개변수 : ExampleVO
//    화면 : exampleVO
    public void ex06(ExampleVO exampleVO, @ModelAttribute("gender") String gender) {
        log.info("-----------------------------");
        log.info(exampleVO.toString());
        log.info("gender : " + gender);
        log.info("-----------------------------");
    }

//    외부에서 4개의 파라미터를 전달받은 후 화면에 전부 출력
    @GetMapping("/ex07")
    public String ex07(ExampleVO exampleVO, String gender, double weight, Model model){

        log.info("-----------------------------");
        log.info(exampleVO.toString());
        log.info("gender : " + gender);
        log.info("weight : " + weight);
        log.info("-----------------------------");

        model.addAttribute("gender", gender);
        model.addAttribute("weight", weight);
        return "ex07";
    }
//    숙제
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언

//    ex/ex08 요청에 실행될 메소드 선언
//    GET 방식
//    ex08.html 선언
//    사용자가 전달한 점수의 총점과 평균 점수 출력

}

















