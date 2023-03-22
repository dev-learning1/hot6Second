package com.hot6.web.spring.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class RankingDTO {

    // 아이디
    private String userEmail;
    // 유저 번호
    @NonNull
    private Long userNumber;
    // 유저 학급
    private String userGrade;
    // 유저 이름
    private String userName;
    //   문제 정답 여부
    private Long myQuizCorrect;
    //   문제 번호
    @NonNull
    private Long quizNumber;
    //   유저 점수
    private Long userPoint;
    // 맞은 문제 갯수
    private Long userCorrectCount;

    // 틀린 문제 갯수
    private Long userWrongCount;
    // 정답률
    private Long userCorrectPercent;
    // 유저 랭킹
    private Long userRanking;
    // 닉네임
    private String userNickname;




    public void calculateCorrectPercent() {
        if (this.userCorrectCount + this.userWrongCount == 0) {
            this.userCorrectPercent = 0L;
        } else {
            this.userCorrectPercent = (this.userCorrectCount * 100) / (this.userCorrectCount + this.userWrongCount);
        }

    }


}
