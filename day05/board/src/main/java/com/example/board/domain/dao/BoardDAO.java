package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//dao를 다시 쓰는 이유. mapper를 컨트롤러에서 바로 쓰면 결합성이 강해지기 때문에 한번 더 걸러준다.
//여러가지의 mapper메소드들을 하나로 묶어서 서비스로 보내기 위해서이다.
@Repository
@RequiredArgsConstructor //생성사 주입
public class BoardDAO {
    private final BoardMapper boardMapper;
//메소드 이름도 더 서비스화 시켜서 만들어 준다.
    public List<BoardVO> getList(Criteria criteria) {return boardMapper.getList(criteria);}
    public void register(BoardVO boardVO) {boardMapper.insertSelectBno(boardVO);}
    public boolean modify(BoardVO boardVO) {return boardMapper.update(boardVO) == 1;}
    public boolean remove(Long bno) {return boardMapper.delete(bno) == 1;}
    public BoardVO get(Long bno) {return boardMapper.get(bno);}
    public int getTotal() {return boardMapper.getTotal();}
}