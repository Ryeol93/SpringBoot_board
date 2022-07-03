package com.example.ex00.dependency;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
//@ToString
//@Getter
//@AllArgsConstructor // 전체 필드를 초기화하는 생성자를 선언한다.
@RequiredArgsConstructor // final 또는 @NonNull이 붙은 필드만 생성자로 선언한다.
public class Coding {
//    필드 주입 (생성자 호출이 먼저 되므로 final을 붙이면 오류가 난다)
//    굉장히 편하게 주입할 수 있으나 순환 참조(무한 루프)시 오류가 발생하지 않기 때문에 StackOverFlow 발생.
//    final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
//    인터페이스는 반드시 필드 주입을 사용해야 한다.
//    spring 컨테이너에서만 가능하다
//    @Autowired (final이 선언되서 나고 사용된다)
    private final Computer computer;

//    생성자 주입
//    순환 참조 시 컴파일러가 인지 가능. 오류 발생
//    메모리에 할당하면서 초기값으로 주입되므로 final 키워드 사용 가능, 다른 곳에서 변형 불가능(안전).
//    의존성 주입이 되지 않으면 객체가 생성되지 않으므로 NPE(널포인터인셉션) 방어,
//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer; // 생정자호출되서나서 바로 실행(final을 붙여도 된다.)
//    }

//    setter 주입
//    굉장히 편하게 주입할 수 있으나 순환 참조(무한 루프)시 오류가 발생하지 않기 때문에 StackOverFlow 발생.
//    final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
//    spring 컨테이너 뿐만 아니라 외부에서 직접 주입이 가능함.
//    @Autowired
//    public void setComputer(Computer computer) { // 매개변수는 화면에서 사용자한테 입력받은 값
//        this.computer = computer;
//    }


}
