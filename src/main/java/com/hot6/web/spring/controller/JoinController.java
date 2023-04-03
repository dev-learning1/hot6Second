package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.UserVO;
import com.hot6.web.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class JoinController {
    private final UserService userService;
    // 로그인/회원가입 창 페이지
    @GetMapping("/login")
    public void login(){;}

    // 학생 회원가입 페이지 이동
    // 기업 회원가입 페이지 이동
    @GetMapping(value = {"/join", "/joinCompany"})
    public void join(Model model){
        model.addAttribute("userInfo", new UserVO());
    }

    // 로그인 확인 페이지
    @GetMapping(value = {"/logincheck", "/logincheck?error"})
    public void logincheck(Model model){
        model.addAttribute("loginInfo", new UserVO());
    }

    // 일반 정보 추가
    @PostMapping("/join")
    public String joinUser(UserVO userVO){
        userService.saveUser(userVO);
        return "/login/login";
    }
    // 기관 정보 추가
    @PostMapping("/joinCompany")
    public String joinCompany(UserVO userVO){
        userService.saveCompany(userVO);
        return "/login/login";
    }

    // 로그인 맞는지 틀린지 확인
    @PostMapping("/logincheck")
    public RedirectView logincheck(UserVO userVO, HttpServletRequest request, RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();
        if(userService.checkUser(userVO) == 1){
            session.setAttribute("userEmail", userVO.getUserEmail());
            session.setAttribute("userNumber", userService.getUserNumber(userVO.getUserEmail()));
            session.setAttribute("userType", userService.getUserType(userVO.getUserEmail()));
            session.setAttribute("userNickname", userService.getUserNickname(userVO.getUserEmail()));
            System.out.println("userEmail: " + userVO.getUserEmail());
            System.out.println("userType: " + userVO.getUserType());
            return new RedirectView("/main/main");
        }else{
            redirectAttributes.addFlashAttribute("error", "error");
            return new RedirectView("logincheck?error");
        }
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null){
            session.invalidate();
        }
        return new RedirectView("/main/main");
    }
}