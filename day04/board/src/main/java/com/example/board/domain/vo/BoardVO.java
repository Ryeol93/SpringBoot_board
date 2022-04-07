package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardVO {
//    Long 넉넉하게 쓰기 위해서 
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private String regdate;
    private String updateDate;
}
