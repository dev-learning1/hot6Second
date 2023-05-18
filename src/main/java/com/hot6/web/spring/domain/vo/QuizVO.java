package com.hot6.web.spring.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class QuizVO {
    //   문제 번호
    @NonNull
    private Long quizNumber;
    //   문제 제목
    private String quizTitle;
    //   문제 내용
    private String quizContent;
    //   문제 리스트
    @NonNull
    private Long quizList;
    //   문제 리스트 제목
    private String quizListTitle;
    //   문제 등록날짜
    private String quizRegisterDate;
    //    문제 수정날짜
    private String quizUpdateDate;
    //   문제 시작 날짜
    private String quizStartDate;
    //    문제 끝나는 날짜
    private String quizFinishDate;
    //    문제 테마(오늘의문제(0), 대회(1))
    private String quizTheme;
    //    문제 정답 유형(객관식(0), 주관식(1))
    private String quizType;
    //   문제 답안1
    @NonNull
    private String quizOne;
    //   문제 답안2
    private String quizTwo;
    //   문제 답안3
    private String quizThree;
    //   문제 답안4
    private String quizFour;
    //   문제 답안5
    private String quizFive;
    //   문제 해설
    private String quizCommentary;
    //    유저 번호
    @NonNull
    private Long userNumber;
    //   문제 난이도
    private String quizLevel;

//    private List<QuizVO> quizVOs;


    public void create(String quizTitle, String quizContent, String quizListTitle, String quizTheme, String quizType, @NonNull String quizOne, String quizTwo, @NonNull Long userNumber, String quizLevel) {
        this.quizTitle = quizTitle;
        this.quizContent = quizContent;
//        this.quizList = quizList;
        this.quizListTitle = quizListTitle;
        this.quizTheme = quizTheme;
        this.quizType = quizType;
        this.quizOne = quizOne;
        this.quizTwo = quizTwo;
        this.userNumber = userNumber;
        this.quizLevel = quizLevel;
    }


}