package com.hot6.web.spring.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class UserDTO {
    //   유저 번호
    private Long userNumber;
    //   유저 이메일
    private String userEmail;
    //   유저 비밀번호
    private String userPassword;
    //   유저 이름
    private String userName;
    //   유저 상세메세지
    private String userMsg;
    //   유저 생년월일
    private String userBirth;
    //    유저 학교
    private String userSchool;
    //   유저 폰번호
    private String userPhonenum;
    //    유저 닉네임
    private String userNickname;
    //   유저 타입
    private String userType;
    //   유저 초중고
    private String userGrade;
    //   유저 점수
    private Long userPoint;
    private Long userCorrectCount;
    private Long userWrongCount;
    private Long userRanking;

    private List<ThumbVO> thumbs;

    public void create(UserVO userVO) {
        this.userNumber = userVO.getUserNumber();
        this.userEmail = userVO.getUserEmail();
        this.userPassword = userVO.getUserPassword();
        this.userName = userVO.getUserName();
        this.userMsg = userVO.getUserMsg();
        this.userBirth = userVO.getUserBirth();
        this.userSchool = userVO.getUserSchool();
        this.userPhonenum = userVO.getUserPhonenum();
        this.userNickname = userVO.getUserNickname();
        this.userType = userVO.getUserType();
        this.userGrade = userVO.getUserGrade();
        this.userPoint = userVO.getUserPoint();
        this.userCorrectCount = userVO.getUserCorrectCount();
        this.userWrongCount = userVO.getUserWrongCount();
        this.userRanking = userVO.getUserRanking();
    }

    public void create(UserVO userVO, List<ThumbVO> thumbs) {
        this.userNumber = userVO.getUserNumber();
        this.userEmail = userVO.getUserEmail();
        this.userPassword = userVO.getUserPassword();
        this.userName = userVO.getUserName();
        this.userMsg = userVO.getUserMsg();
        this.userBirth = userVO.getUserBirth();
        this.userSchool = userVO.getUserSchool();
        this.userPhonenum = userVO.getUserPhonenum();
        this.userNickname = userVO.getUserNickname();
        this.userType = userVO.getUserType();
        this.userGrade = userVO.getUserGrade();
        this.userPoint = userVO.getUserPoint();
        this.userCorrectCount = userVO.getUserCorrectCount();
        this.userWrongCount = userVO.getUserWrongCount();
        this.userRanking = userVO.getUserRanking();
        this.thumbs = thumbs;
    }
}