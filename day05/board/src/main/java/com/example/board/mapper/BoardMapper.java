package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper /* @MapperScan의 대상이 되기위해*/
public interface BoardMapper {
//    게시글 목록
    public List<BoardVO> getList(Criteria criteria);

//    게시글 작성 (insert)
    public void insert(BoardVO boardVO);

//    게시글 작성
//    selectKey를 통해서 전달된 결과는 boardVO필드에 매핑된 후 주입된다.
    public void insertSelectBno(BoardVO boardVO);


//    게시글 수정(update) // 게시글 번호랑 제목 내용을 매개변수 3개를 넣으면 별로이므로/ boardVO를 받는다
    public int update(BoardVO boardVO);

//    게시글 삭제(delete)
    public int delete(Long bno);

//    특정 게시글 가져오기(get)
//    하나 가져오니깐 BoardVO 타입
    public BoardVO get(Long bno);

//    전체 게시글 개수(getTotal)
    public int getTotal();
}
