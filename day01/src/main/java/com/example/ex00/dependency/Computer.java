package com.example.ex00.dependency;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component // 해당 객체를 Spring에서 관리하도록 설정
@Data // 게터,셋터, 해쉬코드, toString 다 알아서 생성됌.(롬복이라는 라이브러리에 들어있다)
public class Computer {}
