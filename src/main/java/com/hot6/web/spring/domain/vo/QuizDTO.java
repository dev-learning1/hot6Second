package com.hot6.web.spring.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class QuizDTO {
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
    //    문제 제출 날짜(마이페이지에서 문제 조회할 때 사용)
    private String myQuizSubmitDate;
    //    문제 테마(오늘의문제(0), 대회(1))
    private String quizTheme;
    //    문제 정답 유형(객관식(0), 주관식(1))
    private String quizType;
    //   정답
    @NonNull
    private String quizOne;
    //   문제 답안1
    private String quizTwo;
    //   문제 답안2
    private String quizThree;
    //   문제 답안3
    private String quizFour;
    //   문제 답안4
    private String quizFive;
    //   문제 해설
    private String quizCommentary;

//    //   내 문제 답안(주관식)
//    private String quizAnsOne;
//    //   내 문제 답안2
//    private String quizAnsTwo;
//    //   내 문제 답안3
//    private String quizAnsThree;
//    //   내 문제 답안4
//    private String quizAnsFour;
//    //   내 문제 답안5
//    private String quizAnsFive;
    //    유저 번호
    @NonNull
    private Long userNumber;
    //   문제 난이도
    private String quizLevel;

//    private String myQuizUserAnsOne;
//    private String quizNumber_myQuizUserAnsOne;
//    private QuizVO quizVO;
//    private List<QuizDTO> quizDTOS;
//    private String userEmail;
//    private String userNickName;
//
//    public String getAnsOne(QuizVO quizVO){
//        if(quizVO.getQuizOne() != null){
//            this.myQuizUserAnsOne = quizVO.getQuizOne();
//        } else if(quizVO.getQuizTwo() != null){
//            this.myQuizUserAnsOne = quizVO.getQuizTwo();
//        } else if(quizVO.getQuizThree() != null){
//            this.myQuizUserAnsOne = quizVO.getQuizThree();
//        }else if(quizVO.getQuizFour() != null){
//            this.myQuizUserAnsOne = quizVO.getQuizFour();
//        }else if(quizVO.getQuizFive() != null){
//            this.myQuizUserAnsOne = quizVO.getQuizFive();
//        }
//        return this.myQuizUserAnsOne;
//    };
//    public String getAnsOne(){
//        if(quizVO.getQuizOne() != null){
//            this.myQuizUserAnsOne = quizVO.getQuizOne();
//        } else if(quizAnsTwo != null){
//            this.myQuizUserAnsOne = quizAnsTwo;
//        } else if(quizAnsThree != null){
//            this.myQuizUserAnsOne = quizAnsThree;
//        }else if(quizAnsFour != null){
//            this.myQuizUserAnsOne = quizAnsFour;
//        }else if(quizAnsFive != null){
//            this.myQuizUserAnsOne = quizAnsFive;
//        }
//        return this.myQuizUserAnsOne;
//    };

    // admin 입력값
//    private String quizOne;
//    private String quizTwo;
//    private String quizThree;
//    private String quizFour;
//    private String quizFive;
    private String userName;
    private String r;

//    public static class QuizDTOList {
//        List<QuizDTO> quizDTOList;
//    }

    public void create(String quizTitle, String quizContent, @NonNull Long quizList, String quizListTitle, String quizTheme, String quizType, @NonNull String quizAnsOne, @NonNull Long userNumber) {

    }

//    public QuizDTO(String quizRegisterDate, String quizUpdateDate) {
//        this.quizRegisterDate = quizRegisterDate;
//        this.quizUpdateDate = quizUpdateDate;
//    }

}