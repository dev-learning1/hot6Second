package com.hot6.web.spring.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardVO {
    //    게시판 번호
    private Long boardNumber;
    //    게시글 이름
    private String boardTitle;
    //    게시글 내용
    private String boardContent;
    //    게시글 날짜
    private String boardDate;
    //    게시글 수정 날짜
    private String boardUpdateDate;
    //    게시글 타입
    private String boardType;
    //  유저 번호
    private Long userNumber;
    //    문제 패키지 번호
    private Long quizList;
    //    문제 번호
    private Long quizNumber;
    //    신고 개수
    private Long boardReport;

    public void create(String boardTitle, String boardContent, String boardType, Long userNumber, Long quizList, Long quizNumber){
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardType = boardType;
        this.userNumber = userNumber;
        this.quizList = quizList;
        this.quizNumber = quizNumber;

    }
    

    public void createType(String boardType){
        this.boardType = boardType;
    }
}