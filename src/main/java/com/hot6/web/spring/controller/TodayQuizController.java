package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.service.ContestQuizService;
import com.hot6.web.spring.service.MyQuizService;
import com.hot6.web.spring.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class TodayQuizController {
    private final QuizService quizService;
    private final MyQuizService myQuizService;
    private final ContestQuizService contestQuizService;

    // 오늘의 문제 목록
    @GetMapping("/problemList")
    public void problemList(Criteria criteria, Model model) {
        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }
        model.addAttribute("todayQuizs", quizService.showListAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, quizService.getListTotal()));
    }

    @GetMapping("/contestList")
    public void contestList(Criteria criteria, Model model) {
        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }

        model.addAttribute("contestQuizs", quizService.showListAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, quizService.getListTotal()));
    }


    // 오늘의 문제 상세조회 이동
    @GetMapping("/problemDetail")
    public void problemDetail(Long quizList, QuizVO quizVO, Criteria criteria, Model model) {
        model.addAttribute("todayQuizList", quizService.showList(quizList));
        model.addAttribute("myQuiz", new MyQuizVO());
//        model.addAttribute("myQuizAns", new MyQuizVO().getMyQuizUserAnsOne());
//        model.addAttribute("examples", quizDTO.getExample());
    }

    @PostMapping("/problemDetail")
    public RedirectView problemDetail(MyQuizVO myQuizVO, QuizVO quizVO, RedirectAttributes redirectAttributes) {
        myQuizVO.setUserNumber(41L);
        myQuizVO.setQuizNumber(12L);

        myQuizService.register(myQuizVO);
        myQuizService.modify(myQuizVO.getQuizNumber(), myQuizVO.getUserNumber());

        redirectAttributes.addAttribute("quizList", quizVO.getQuizList());//quizVO.getQuizList()
        return new RedirectView("/board/problemAnswer");
    }

    /// 대회 문제 작성 페이지 이동
    @GetMapping("/contestWrite")
    public void contestWrite(Model model) {
        model.addAttribute("contestQuizList", new QuizVO());
    }


    @PostMapping("/contestWrite")
    public RedirectView contestWrite(QuizVO quizVO, RedirectAttributes redirectAttributes) {
        quizVO.setQuizTheme("1");
        contestQuizService.register(quizVO);

        redirectAttributes.addAttribute("quizList", quizVO.getQuizList());
        return new RedirectView("/board/contestList");
    }

    @PostMapping("/contestWriteAll")
    public RedirectView contestWrite(@RequestBody List<QuizVO> quizList, RedirectAttributes redirectAttributes) {
        for (QuizVO quizVO : quizList) {
            quizVO.setQuizTheme("1");
            contestQuizService.register(quizVO);
        }

        return new RedirectView("/board/contestList");
    }




    // 오늘의 문제 답안 임시저장

//    // 오늘의 문제 답안지 페이지 이동
//    @GetMapping("/problemDetailOk")
//    public void problemDetailOk(Criteria criteria, Model model) {
////        model.addAttribute("todayQuizList", quizService.showList(quizList));
//    }

    // 오늘의 문제 답안지 조회
//    @GetMapping("/problemAnswer")
//    public void problemAnswer(Long quizList, Model model){
//        model.addAttribute("todayQuizAnswer", quizService.showList(quizList));
//    }
    @GetMapping("/problemAnswer")
    public void problemAnswer(Criteria criteria, Long quizList, Model model) {
        model.addAttribute("todayQuizList", quizService.showList(quizList));

    }


}