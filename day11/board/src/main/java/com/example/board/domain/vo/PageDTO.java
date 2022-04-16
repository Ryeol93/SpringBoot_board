package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageDTO {
//    화면쪽에 파라미터로 전달될 객체이다(PageDTO)/ DB에서 조회를 한게아니라 우리가 연산한 결과를 넣는것이다.
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;

    private Criteria criteria;
//    realEnd구하기 위해 total필요
    private int total;
    private int pageCount;

    public PageDTO() {;}

    public PageDTO(Criteria criteria, int total) {
        this(criteria, total, 10);
    }

    public PageDTO(Criteria criteria, int total, int pageCount){
        this.criteria = criteria;
        this.total = total;
        this.pageCount = pageCount;

//        10.0은 범위에 관련된것 모든숫자를 1로 바꿔주기 위해 사용
//        pageCount는 자기가 보여줄 페이지 개수. 기본값은 10으로하고 변경시 DTO에서 원하는 값을 주면된다.
        this.endPage = (int)(Math.ceil(criteria.getPageNum() / 10.0)) * pageCount;
        this.startPage = endPage - pageCount + 1;

        /*realEnd 구하기 ex) 총개수가 136개이면 페이지는 14페이지가 끝. 20페이지x */
        realEnd = (int)(Math.ceil(total/ (double)criteria.getAmount()));

        /*endPage와 비교*/
        if(realEnd < this.endPage){
            this.endPage = realEnd == 0? 1: realEnd;
        }

        /*prev */
        this.prev = this.startPage > 1;
        /*next */
        this.next = this.endPage < realEnd;

    }
}











