package com.hot6.web.spring.controller;


import com.hot6.web.spring.domain.vo.BoardDTO;
import com.hot6.web.spring.domain.vo.BoardVO;
import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.PageDTO;
import com.hot6.web.spring.service.BoardService;
import com.hot6.web.spring.service.CommunityBoardService;
import com.hot6.web.spring.service.ReplyService;
import com.hot6.web.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;
    private final ReplyService replyService;
    private final CommunityBoardService communityBoardService;
    private final UserService userService;

    // 게시글 목록
    @GetMapping("/boardList")
    public void bordList(Criteria criteria, Model model, @SessionAttribute(name="userEmail", required = false) String userEmail){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }


        model.addAttribute("boards", communityBoardService.showAll(criteria));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, communityBoardService.getTotal()));

    }


    @GetMapping("/boardListBy")
    @ResponseBody
    public ResponseEntity<String> boardListBy(@RequestParam String boardType) {

        List<BoardDTO> boardList = communityBoardService.showAllBy(boardType);
        String htmlData = "";

        for (BoardDTO board : boardList) {
            htmlData += "<article><aside>" + board.getQuizList() + "-" + board.getQuizNumber() + "</aside>"
                    + "<div class='questionContent'><div class='questionTitle' style='display: flex; justify-content: space-between;'>"
                    + "<a class='boardDetail' href='" + board.getBoardNumber() + "'>" + board.getBoardTitle() + "</a>"
                    + "<div class='boardWriter'>" + board.getUserNickName() + "</div></div>"
                    + "<div class='questionOption'><div class='questionIcons'>"
                    + "<span>" + board.getBoardReport() + "</span></div>"
                    + "<span class='questionTime'>" + board.getBoardDate() + "</span></div></div></article>";
        }

        return ResponseEntity.ok(htmlData);
    }




    // 게시글 등록
    @GetMapping("/boardWrite")
    public void boardWrite(Model model){
        model.addAttribute("board", new BoardVO());
    }


    @PostMapping("/boardWrite")
    public RedirectView write(BoardVO boardVO, RedirectAttributes redirectAttributes, @SessionAttribute(name="userNumber", required = false) Long userNumber){
        communityBoardService.register(boardVO);
        redirectAttributes.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        return new RedirectView("/board/boardList");
    }

    // 게시글 상세 조회
    @GetMapping("/boardDetail")
    public void boardDetail(Long boardNumber, Criteria criteria, Model model){
        model.addAttribute("replyCount", replyService.count(boardNumber));
        model.addAttribute("board", communityBoardService.show(boardNumber));
    }
    // 게시글 수정
    @GetMapping("/boardUpdate")
    public void boardUpdate(Long boardNumber, Criteria criteria, Model model){
        model.addAttribute("board", communityBoardService.show(boardNumber));
    }

    // 게시글 수정(완료)
    @PostMapping("/boardUpdate")
    public RedirectView boardUpdate(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        communityBoardService.modify(boardDTO);
        redirectAttributes.addAttribute("boardNumber", boardDTO.getBoardNumber());
        return new RedirectView("/board/boardDetail");
    }

    // 게시글 삭제
    @GetMapping("/boardDelete")
    public RedirectView boardDelete(Long boardNumber){
        communityBoardService.remove(boardNumber);
        return new RedirectView("/board/boardList");
    }
}