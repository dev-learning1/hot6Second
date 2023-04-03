package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.service.ContestQuizService;
import com.hot6.web.spring.service.MyQuizService;
import com.hot6.web.spring.service.QuizService;
import com.hot6.web.spring.service.UserService;
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
    private final UserService userService;

    // 오늘의 문제 목록
    @GetMapping("/problemList")
    public void problemList(Criteria criteria, Model model, @SessionAttribute(name="userEmail", required = false) String userEmail, @SessionAttribute(name="userNickname", required = false) String userNickname) {
        String quizTheme = "0";
        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userNickname);
        model.addAttribute("todayQuizs", quizService.showListAll(criteria, quizTheme));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, quizService.getListTotal(quizTheme)));
    }

    @GetMapping("/contestList")
    public void contestList(Criteria criteria, Model model, @SessionAttribute(name="userEmail", required = false) String userEmail, @SessionAttribute(name="userType", required = false) String userType, @SessionAttribute(name="userNickname", required = false) String userNickname) {
        String quizTheme = "1";

        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }

        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userType", userType);
        model.addAttribute("userNickname", userNickname);
        model.addAttribute("contestQuizs", quizService.showContestListAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, quizService.getListTotal(quizTheme)));
    }


    // 오늘의 문제 상세조회 이동
    @GetMapping("/problemDetail")
    public void problemDetail(Long quizList, Criteria criteria, Model model, @SessionAttribute(name="userEmail", required = false) String userEmail, @SessionAttribute(name="userNickname", required = false) String userNickname) {
        model.addAttribute("todayQuizList", quizService.showList(quizList));
        model.addAttribute("myQuiz", new MyQuizVO());
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userNickname);
    }

    @PostMapping("/problemDetail")
    public RedirectView problemDetail(MyQuizVO myQuizVO, @SessionAttribute(name="userEmail", required = false) String userEmail, @RequestParam(name = "quizList") Long quizList, @RequestParam(name = "quizNumber") Long quizNumber, RedirectAttributes redirectAttributes) {
        System.out.println("quizList: " +quizList);
        myQuizVO.setUserNumber(userService.getUserNumber(userEmail));
        myQuizVO.setQuizNumber(quizNumber);

        myQuizService.register(myQuizVO);
//        myQuizService.modify(myQuizVO.getQuizNumber(), myQuizVO.getUserNumber());

        redirectAttributes.addAttribute("quizList", quizList);
        return new RedirectView("/board/problemAnswer");
    }

    // 대회 문제 작성 페이지 이동
    @GetMapping("/contestWrite")
    public void contestWrite(Model model, @SessionAttribute(name="userEmail", required = false) String userEmail, @SessionAttribute(name="userNickname", required = false) String userNickname) {
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userNickname);
        model.addAttribute("contestQuizList", new QuizVO());
    }

//, @RequestParam(name = "quizStartDate") String quizStartDate, @RequestParam(name = "quizFinishDate") String quizFinishDate
    @PostMapping("/contestWrite")
    public RedirectView contestWrite(QuizVO quizVO, @SessionAttribute(name="userEmail", required = false) String userEmail, RedirectAttributes redirectAttributes) {
        quizVO.setQuizTheme("1");
        quizVO.setUserNumber(userService.getUserNumber(userEmail));
//        quizVO.setQuizStartDate(quizStartDate);
//        quizVO.setQuizFinishDate(quizFinishDate);
        System.out.println("getQuizStartDate: " + quizVO.getQuizStartDate());
        System.out.println("getQuizFinishDate: " + quizVO.getQuizFinishDate());
        contestQuizService.register(quizVO);

        System.out.println("contestWrite");
        System.out.println("quizvo: "+ quizVO);

        redirectAttributes.addAttribute("quizList", quizVO.getQuizList());
        return new RedirectView("/board/contestList");
    }

    @PostMapping("/contestWriteAll")
    public RedirectView contestWrite(@RequestBody List<QuizVO> quizList, RedirectAttributes redirectAttributes) {
        System.out.println("contestWriteAll");
        for (QuizVO quizVO : quizList) {
            quizVO.setQuizTheme("1");
            contestQuizService.register(quizVO);
        }

        return new RedirectView("/board/contestList");
    }

    // 오늘의 문제 답안
    @GetMapping("/problemAnswer")
    public void problemAnswer(Long quizList, Criteria criteria, Model model, @SessionAttribute(name="userEmail", required = false) String userEmail, @SessionAttribute(name="userNickname", required = false) String userNickname) {
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userNickname);
        model.addAttribute("todayQuizList", quizService.showList(quizList));

    }


}