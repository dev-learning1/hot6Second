package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.service.BoardService;
import com.hot6.web.spring.service.CommunityBoardService;
import com.hot6.web.spring.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final RankingService rankingService;
    private final BoardService boardService;
    private final CommunityBoardService communityBoardService;

    @GetMapping("/main")
    public void main(Long boardNumber, Model model, @SessionAttribute(name="userEmail", required = false) String userEmail) {
        model.addAttribute("boards", communityBoardService.showAllMain());
        // 랭킹
        model.addAttribute("rankingC", rankingService.showAllBy("elementary"));
        model.addAttribute("rankingJ", rankingService.showAllBy("middle"));
        model.addAttribute("rankingK", rankingService.showAllBy("high"));

        model.addAttribute("userEmail", userEmail);
        }

    // 오늘의 문제 페이지 이동
    @GetMapping("/problem")
    public String problem() {return "/board/problemList";}

    // 대회 페이지 이동
    @GetMapping("/contest")
    public String contest() {return "/board/contestList";}




    // 게시판 페이지 이동
    @GetMapping("/board")
    public String board() {return "/board/boardList";}


}
