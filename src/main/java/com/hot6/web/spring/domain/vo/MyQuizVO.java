package com.hot6.web.spring.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class MyQuizVO {
    //   문제 번호
    @NonNull
    private Long myQuizNumber;
    //   문제 정답 여부
    private Long myQuizCorrect;
    //   문제 임시 저장 날짜
    private String myQuizWaitDate;
    //   문제 제출 날짜
    private String myQuizSubmitDate;
    //    유저 번호
    @NonNull
    private Long userNumber;
    //   문제 번호
    @NonNull
    private Long quizNumber;
    //    나의 답
//    private String myQuizAns;
    private String myQuizUserAnsOne;
    private QuizVO quizVO;
//    private List<QuizVO> quizVOS;

    public String getAnsOne(QuizVO quizVO){
        if(quizVO.getQuizOne() != null){
            this.myQuizUserAnsOne = quizVO.getQuizOne();
        } else if(quizVO.getQuizTwo() != null){
            this.myQuizUserAnsOne = quizVO.getQuizTwo();
        } else if(quizVO.getQuizThree() != null){
            this.myQuizUserAnsOne = quizVO.getQuizThree();
        }else if(quizVO.getQuizFour() != null){
            this.myQuizUserAnsOne = quizVO.getQuizFour();
        }else if(quizVO.getQuizFive() != null){
            this.myQuizUserAnsOne = quizVO.getQuizFive();
        }
        return this.myQuizUserAnsOne;
    };

    private List<MyQuizVO> myQuizVOS;

//    public void create(@NonNull Long userNumber, @NonNull Long quizNumber, String myQuizUserAnsOne) {
////        this.myQuizNumber = myQuizNumber;
////        this.myQuizCorrect = myQuizCorrect;
////        this.myQuizWaitDate = myQuizWaitDate;
////        this.myQuizSubmitDate = myQuizSubmitDate;
//        this.userNumber = userNumber;
//        this.quizNumber = quizNumber;
//        this.myQuizUserAnsOne = myQuizUserAnsOne;
//    }
}