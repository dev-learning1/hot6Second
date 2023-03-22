package com.hot6.web.spring.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MyQuizVO {
    //   문제 번호
    @NonNull
    private Long myQuizNumber;
    //   문제 정답 여부
    private boolean myQuizCorrect;
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