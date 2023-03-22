package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.xml.ws.Service;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;
    Long inReplyNumber;
    //메인 페이지
    @GetMapping("/adm_main")
    public void mainPage(){

    }

    // 오늘의 문제 전체 조회
    @GetMapping("/adm_todayList")
    public void todayList(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("quizs", adminService.showAllToday(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getToday()));
    }
    // 오늘의 문제 페이지 추가이동
    @GetMapping("/adm_todayInsert")
    public void insertPage(Criteria criteria, Model model){
        model.addAttribute("quiz",new QuizDTO());
    }

    // 오늘의 문제 등록
    @PostMapping("/write")
    public RedirectView write(QuizDTO quizDTO, RedirectAttributes redirectAttributes){
        adminService.registerToday(quizDTO);
        //redirectAttributes.addFlashAttribute("quizNumber", quizDTO.getQuizNumber());
        return new RedirectView("/admin/adm_todayList");
    }

    // 문의글 댓글 등록
    @PostMapping("/replyWrite")
    public RedirectView replyWrite(InReplyVO inReplyVO, RedirectAttributes redirectAttributes){
        inReplyVO.setBoardNumber(inReplyNumber);
        adminService.addInReply(inReplyVO);
        redirectAttributes.addFlashAttribute("boardNumber",inReplyVO.getBoardNumber());
        Long boardNumber = inReplyVO.getBoardNumber();
        return new RedirectView("/admin/adm_inquiryDetail?boardNumber="+boardNumber);
    }

    // 오늘의 문제 상세정보
    @GetMapping("/adm_todayDetail")
    public void todayDetail(Long quizNumber, Model model){ model.addAttribute("quiz", adminService.showTodayDetail(quizNumber)); }
    // 오늘의 문제 삭제
    @GetMapping("/deleteToday")
    public RedirectView deleteToday(Long quizNumber){
        adminService.deleteToday(quizNumber);
        return new RedirectView("/admin/adm_todayList");
    }

    @GetMapping("/deleteBoard")
    public RedirectView deleteBoard(Long boardNumber){
        adminService.deleteAdmBoard(boardNumber);
        return new RedirectView("/admin/adm_boardList");
    }
    @PostMapping("/modify")
    public RedirectView todayModify(QuizDTO quizDTO, RedirectAttributes redirectAttributes){
        adminService.updateToday(quizDTO);
        //redirectAttributes.addFlashAttribute("quizNumber", quizDTO.getQuizNumber());
        return new RedirectView("/admin/adm_todayList");
    }
    @GetMapping("/adm_todayDetailTemp")
    public void todayTemp(Long quizNumber, Model model){ model.addAttribute("quiz", adminService.showTodayDetail(quizNumber)); }

    // 대회 문제 전체 조회
    @GetMapping("/adm_contestList")
    public void contestList(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("boards", adminService.showAllContest(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getTodayContest()));
    }
    // 회원 목록 전체 보기
    @GetMapping("/adm_userList")
    public void userList(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("boards", adminService.showAllUser(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getTotal()));
    }

    // 회원 상세정보 보기
    @GetMapping("/adm_userDetail")
    public void userDetail(Long userNumber, Criteria criteria, Model model){ model.addAttribute("board", adminService.showUser(userNumber)); }

    // 회원 삭제
    @GetMapping("/delete")
    public RedirectView delete(Long userNumber){
        adminService.remove(userNumber);
        return new RedirectView("/admin/adm_userList");
    }

    // 작성 게시글
    @GetMapping("/adm_boardList")
    public void boardList(Model model, Criteria criteria, String comCd){
        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }
        if(comCd == null||comCd.equals("시간순")) {
            model.addAttribute("boards", adminService.showAllBoards(criteria));
        }else if(comCd.equals("신고순")){
            model.addAttribute("boards", adminService.selectAllBoardReport(criteria));
        }
        model.addAttribute("cmdList", new CmdList());
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getBoardTotal()));
    }
    // 작성 게시글 상세조회
    @GetMapping("/adm_boardDetail")
    public void boardDetail(Long boardNumber, Criteria criteria, Model model){
        model.addAttribute("board", adminService.admBoardDetail(boardNumber));
        model.addAttribute("before", adminService.beforeBoardInquiry(boardNumber));
        model.addAttribute("after", adminService.afterBoardInquiry(boardNumber));
    }

    @GetMapping("/new")
    public void comList(String comCd){
        //return new RedirectView("/admin/adm_boardList");
    }
    // 문의글 전체 보기
    @GetMapping("/adm_inquiryList")
    public void inquiryList(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("boards", adminService.showAllInquiry(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getInquiryTotal()));
    }
    // 문의글 상세보기
    @GetMapping("/adm_inquiryDetail")
    public void inquiryDetail(Long boardNumber, Criteria criteria, Model model){
        model.addAttribute("boards",adminService.showInquiry(boardNumber));
        model.addAttribute("replys", adminService.showAllInReply(boardNumber));
        model.addAttribute("count", adminService.getTotalReply(boardNumber));
        model.addAttribute("before", adminService.beforeInquiry(boardNumber));
        model.addAttribute("after",adminService.afterInquiry(boardNumber));
        model.addAttribute("inReply", new InReplyVO());
        inReplyNumber = boardNumber;
        if(adminService.showAllInReply(boardNumber).size()==0) { model.addAttribute("replys", 0);}
    }
}