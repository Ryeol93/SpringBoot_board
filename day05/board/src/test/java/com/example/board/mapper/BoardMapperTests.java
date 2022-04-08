package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired // 인스턴스가 자동으로 주입 해당 변수 및 메서드에 스프링이 관리하는 Bean을 자동으로 매핑해주는 개념
    private BoardMapper boardMapper;

//    @Test
//    public void testInsertSelectBno(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setTitle("테스트 제목2");
//        boardVO.setContent("테스트 내용2");
//        boardVO.setWriter("user00");
//
//        boardMapper.insertSelectBno(boardVO);
//
//        log.info("------------------------------------");
//        log.info(boardVO.toString());
//        log.info("------------------------------------");
//    }

//    @Test
//    public void testGetTotal(){
//        log.info("---------------------------------");
//        log.info("TOTAL : " + String.valueOf(boardMapper.getTotal()));
//        log.info("---------------------------------");
//    }

//    @Test
//    public void testGet(){
//        log.info(boardMapper.get(11L).toString());
//    }

//    @Test
//    public void testDelete(){
//        int result = 0;
//        Long bno = 1L;
//        result = boardMapper.delete(bno);
//
//        log.info("DELETE COUNT : " + result);
//    }

//    @Test
//    public void testUpdate(){
//        int result = 0;
//
//        BoardVO boardVO = new BoardVO();
//        boardVO.setBno(11L);
//        boardVO.setTitle("수정된 제목");
//        boardVO.setContent("수정된 내용");
//
//        result = boardMapper.update(boardVO);
////       boardMapper.update(boardVO) 실행검사 건수 이므로 mapper.xml에서 void->int로
//        log.info("UPDATE COUNT : " + result);
//    }

//    @Test
//    public void testInsert(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setTitle("테스트 제목2");
//        boardVO.setContent("테스트 내용2");
//        boardVO.setWriter("user01");
//
//        boardMapper.insert(boardVO);
//    }

//    @Test
//    public void testGetList(){
//        boardMapper.getList(new Criteria()).forEach(board -> log.info(board.toString()));
//    }
}











