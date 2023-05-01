package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.service.InquiryBoardService;
import com.hot6.web.spring.service.MyQuizService;
import com.hot6.web.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {
    private final UserService userService;
    private final InquiryBoardService inquiryBoardService;
    private final MyQuizService myQuizService;

    // 페이지 이동
//    @GetMapping("/myPageMain")
//    public String pageMain(){
//        return "myPage/myPageMain";
//    }

    @GetMapping("/myPageNoAns")
    public String pageNoAns(){
        return "myPage/myPageNoAns";
    }

    @GetMapping("/myPageQuizNo")
    public void pageQuizNo(Model model, Criteria criteria, CriteriaDTO criteriaDTO, @SessionAttribute(name="userEmail") String userEmail, @SessionAttribute(name="userNumber") Long userNumber){
        if(criteriaDTO.getPage() == 0){
            criteriaDTO.create(1, 5);
        }
        if(criteria.getPage() == 0){
            criteria.create(1, 5);
        }
        criteriaDTO.setUserNumber(userNumber);
        model.addAttribute("userInfo", userService.showUser(userNumber));
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userService.getUserNickname(userEmail));
        model.addAttribute("userQuizNos",myQuizService.findUserQuizNo(criteriaDTO));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, myQuizService.getUserQuizNoTotal(userNumber)));
        model.addAttribute("userInquiryCount", inquiryBoardService.showInquiryCount(userNumber));
        model.addAttribute("userCorrectCount", myQuizService.getUserQuizOkTotal(userNumber));
        model.addAttribute("userWrongCount", myQuizService.getUserQuizNoTotal(userNumber));
        model.addAttribute("userInquiryWaitCount", inquiryBoardService.showInquiryWaitCount(userNumber));
    }

    @GetMapping("/myPageQuizOk")
    public void pageQuizOk(Model model, Criteria criteria, CriteriaDTO criteriaDTO, @SessionAttribute(name="userEmail") String userEmail, @SessionAttribute(name="userNumber") Long userNumber){
        if(criteriaDTO.getPage() == 0){
            criteriaDTO.create(1, 5);
        }
        if(criteria.getPage() == 0){
            criteria.create(1, 5);
        }
        criteriaDTO.setUserNumber(userNumber);
        model.addAttribute("userInfo", userService.showUser(userNumber));
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userService.getUserNickname(userEmail));
        model.addAttribute("userQuizOks",myQuizService.findUserQuizOk(criteriaDTO));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, myQuizService.getUserQuizOkTotal(userNumber)));
        model.addAttribute("userInquiryCount", inquiryBoardService.showInquiryCount(userNumber));
        model.addAttribute("userCorrectCount", myQuizService.getUserQuizOkTotal(userNumber));
        model.addAttribute("userWrongCount", myQuizService.getUserQuizNoTotal(userNumber));
        model.addAttribute("userInquiryWaitCount", inquiryBoardService.showInquiryWaitCount(userNumber));
    }

    @GetMapping("/myPageModal")
    public String pageModal(){
        return "myPage/myPageModal";
    }


    // (바)문의 페이지 이동
    // 유저 정보 받아야함. 유저의 문의글 전체 받아야 함.
    @GetMapping("/myPageInquary")
    public void pageInquiry(Model model, Criteria criteria, CriteriaDTO criteriaDTO, @SessionAttribute(name="userEmail", required = false) String userEmail, @SessionAttribute(name="userNumber") Long userNumber){
        if(criteriaDTO.getPage() == 0){
            criteriaDTO.create(1, 5);
        }
        if(criteria.getPage() == 0){
            criteria.create(1, 5);
        }
        model.addAttribute("userInfo", userService.showUser(userNumber));
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userService.getUserNickname(userEmail));
//        model.addAttribute("boards", inquiryBoardService.findUserInquiry(userEmail));

        criteriaDTO.setUserNumber(userNumber);
        model.addAttribute("boards", inquiryBoardService.showUserInquiryAll(criteriaDTO));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, inquiryBoardService.getUserInquiryTotal(userNumber)));
        model.addAttribute("userInquiryCount", inquiryBoardService.showInquiryCount(userNumber));
        model.addAttribute("userCorrectCount", myQuizService.getUserQuizOkTotal(userNumber));
        model.addAttribute("userWrongCount", myQuizService.getUserQuizNoTotal(userNumber));
        model.addAttribute("userInquiryWaitCount", inquiryBoardService.showInquiryWaitCount(userNumber));
    }


    // 탈퇴

    // 개인 정보 상세 보기
    @GetMapping("/myPageMain")
    public void userInfo(Model model, @SessionAttribute(name="userEmail") String userEmail, @SessionAttribute(name="userNumber") Long userNumber){
//        model.addAttribute("userInfo", userService.getUserInfo(userEmail));
        model.addAttribute("userInfo", userService.showUser(userNumber));
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userNickname", userService.getUserNickname(userEmail));
        model.addAttribute("userInquiryCount", inquiryBoardService.showInquiryCount(userNumber));
        model.addAttribute("userCorrectCount", myQuizService.getUserQuizOkTotal(userNumber));
        model.addAttribute("userWrongCount", myQuizService.getUserQuizNoTotal(userNumber));
        model.addAttribute("userInquiryWaitCount", inquiryBoardService.showInquiryWaitCount(userNumber));
    }

    // 개인 정보 수정
    @PostMapping("/updateInfo")
    public RedirectView updateInfo(UserDTO userDTO, @SessionAttribute(name="userEmail") String userEmail){
        userDTO.setUserEmail(userEmail);
        userService.modifyUser(userDTO);
        return new RedirectView("/mypage/myPageMain");
    }

    // 맞은 문제 리스트

    // 틀린 문제 리스트


    // (헤더)문의하기 페이지 이동
    @GetMapping("/ask")
    public String ask(Model model, @SessionAttribute(name="userNumber") Long userNumber, @SessionAttribute(name="userEmail") String userEmail){
        model.addAttribute("askInfo", new BoardVO());
        model.addAttribute("userEmail", userEmail);
        return "main/askWrite";
    }
    @PostMapping("/sendInquiry")
    public RedirectView sendInqiry(BoardVO boardVO, @SessionAttribute(name="userNumber") Long userNumber){
        boardVO.setUserNumber(userNumber);
        inquiryBoardService.sendInquiry(boardVO);
        return new RedirectView("/mypage/myPageInquary");
    }

    // 탈퇴하기
    @GetMapping("/delete")
    public RedirectView delete(HttpServletRequest request, @SessionAttribute(name="userNumber") Long userNumber){
        userService.removeUser(userNumber);
        HttpSession session = request.getSession();
        if (session != null){
            session.invalidate();
        }
        return new RedirectView("/main/main");
    }
}