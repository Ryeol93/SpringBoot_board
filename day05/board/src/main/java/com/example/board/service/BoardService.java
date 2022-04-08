package com.example.board.service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;


/*
* 1. 느슨한 결합성
* 2. 재활용
* DAO에서 작성한것을 메소드만 가져온다.
* */
@Service // DAO에서 써주는것
public interface BoardService {
    public List<BoardVO> getList(Criteria criteria);
    public void register(BoardVO boardVO);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long bno);
    public BoardVO get(Long bno);
    public int getTotal();
}
