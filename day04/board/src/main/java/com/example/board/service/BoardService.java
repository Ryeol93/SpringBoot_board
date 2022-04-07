package com.example.board.service;

import com.example.board.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;


/*
* 1. 느슨한 결합성
* 2. 재활용
* */
@Service // DAO에서 써주는것
public interface BoardService {
    public List<BoardVO> getList();
    public void register(BoardVO boardVO);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long bno);
    public BoardVO get(Long bno);
    public int getTotal();
}
