package com.example.board.controller;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
/*
 *   Task        URL             Method          Parameter       Form        URL이동
 *   전체 목록    /board/list     GET             없음             없음         없음
 *   등록 처리    /board/register POST            모든 항목         필요         이동
 *   조회        /board/read      GET            bno              필요         없음
 *   삭제 처리    /board/remove   GET             bno              필요         이동
 *   수정 처리    /board/modify   POST            모든 항목         필요         이동
 * */

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;




//    @GetMapping("/list")
//    public void list(Criteria criteria, Model model){
//        log.info("---------------------------");
//        log.info("list");
//        log.info("---------------------------");
//        model.addAttribute("list", boardService.getList(criteria));
//    }


//    @PostMapping("/register")
//    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
//        log.info("---------------------------");
//        log.info("register, " + boardVO);
//        log.info("---------------------------");
//
//        boardService.register(boardVO);

//        쿼리 스트링 (targetRequestParams)
//        rttr.addAttribute("bno", boardVO.getBno());

//        Session 사용 (FlashMap-attributes)
//        rttr.addFlashAttribute("bno", boardVO.getBno());

//        RedirectView를 사용하면 redirect방식으로 전송이 가능하다.
//        HandlerMapping으로 이동하여 다른 페이지를 가야 한다면, Redirect방식으로 이동한다.
//        이 때 같은 컨트롤러라면, 전체 URL 경로가 아닌 메소드의 Mapping URL만 작성해준다.
//        return new RedirectView("list");
//    }

    //조회
    @GetMapping("/read")
    public void read(Long bno, Model model){
        log.info("---------------------------");
        log.info("read" + bno);
        log.info("---------------------------");

        model.addAttribute("board",boardService.get(bno));
    }

    @GetMapping("/remove")
    public void remove(Long bno, RedirectAttributes rttr) {
        String result = null;
        log.info("---------------------------");
        log.info("remove" + bno);
        log.info("---------------------------");

        if (boardService.remove(bno)) {
            result = "success";
        } else {
            result = "failure";
        }
        rttr.addFlashAttribute("result", result);
        return new RedirectView("list");
    }
}















