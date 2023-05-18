package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.service.ContestQuizService;
import com.hot6.web.spring.service.MyQuizService;
import com.hot6.web.spring.service.QuizService;
import com.hot6.web.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<QuizDTO> quizDTOs = quizService.showList(quizList);
        System.out.println("quizDTOs : " + quizDTOs);

        model.addAttribute("todayQuizList", quizDTOs);
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userNickname);
    }


    @PostMapping("/problemDetail")
    public void problemDetail(@RequestBody MyQuizVO myQuiz, @SessionAttribute(name="userEmail", required = false) String userEmail) {

        QuizVO quizVO = quizService.show(myQuiz.getQuizNumber());
        UserVO userVO = userService.getUserInfo(userEmail);
        Long userCorrectCount = userVO.getUserCorrectCount();
        Long userWrongCount = userVO.getUserWrongCount();
        String userAns = myQuiz.getMyQuizUserAnsOne();
        int count = 0;
        Long correct = 0L;
        Long userPoint = userVO.getUserPoint();

        // 객관식 3점
        // 주관식 키워드 개수로 점수 측정. 모든 키워드 포함하면 5점

        // 객관식
        if(quizVO.getQuizType().equals("0")){
            correct = userAns.equals(quizVO.getQuizOne()) ? 1L:0L;
            if(correct.equals(1L)) {
                userCorrectCount += 1;
                userPoint += 3;
            } else{userWrongCount+=1;}
        }
        // 주관식
        if(quizVO.getQuizType().equals("1")){
            List<String> keywordList = new ArrayList<>();
            if (quizVO.getQuizOne() != null) keywordList.add(quizVO.getQuizOne());
            if (quizVO.getQuizTwo() != null) keywordList.add(quizVO.getQuizTwo());
            if (quizVO.getQuizThree() != null) keywordList.add(quizVO.getQuizThree());
            if (quizVO.getQuizFour() != null) keywordList.add(quizVO.getQuizFour());
            if (quizVO.getQuizFive() != null) keywordList.add(quizVO.getQuizFive());
            String[] keywords = keywordList.toArray(new String[0]);

            for (String keyword : keywords) {
                if (userAns.contains(keyword)) {
                    count++;
                }
            }
            correct = count == keywords.length ? 1L:0L;
            if(correct.equals(1L)){
                userCorrectCount += 1;
                userPoint += 5;
            } else {
                userWrongCount+=1;
                userPoint += count;
            }
        }

        myQuiz.setUserNumber(userService.getUserNumber(userEmail));
        myQuiz.setMyQuizCorrect(correct);
        myQuizService.register(myQuiz);


        UserDTO userDTO = new UserDTO();
        // userDTO에 값을 복사
        userVO.setUserPoint(userPoint);
        userVO.setUserWrongCount(userWrongCount);
        userVO.setUserCorrectCount(userCorrectCount);
        BeanUtils.copyProperties(userVO, userDTO);
        userService.modifyUserPoint(userDTO);
    }

    // 정답지 페이지 이동
    @GetMapping("/problemDetailOk")
    public RedirectView problemDetailOk(RedirectAttributes redirectAttributes, @RequestParam Long quizList) {


        redirectAttributes.addAttribute("quizList", quizList);
        return new RedirectView("/board/problemAnswer");
    }


    /// 대회 문제 작성 페이지 이동
    @GetMapping("/contestWrite")
    public void contestWrite(Model model, @SessionAttribute(name="userEmail", required = false) String userEmail, @SessionAttribute(name="userNickname", required = false) String userNickname) {
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userNickname);
        model.addAttribute("contestQuizList", new QuizVO());
    }

    @PostMapping("/contestWrite")
    public void contestWrite(@RequestBody QuizVO quizVO, @SessionAttribute(name="userEmail", required = false) String userEmail) {
        quizVO.setQuizTheme("1");
        quizVO.setQuizList(contestQuizService.getRecentListNumber()+1L);
        quizVO.setUserNumber(userService.getUserNumber(userEmail));
        contestQuizService.register(quizVO);


    }

    @GetMapping("/contestWriteOk")
    public RedirectView contestWriteOk(RedirectAttributes redirectAttributes) {


        redirectAttributes.addAttribute("quizList", contestQuizService.getRecentListNumber());
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