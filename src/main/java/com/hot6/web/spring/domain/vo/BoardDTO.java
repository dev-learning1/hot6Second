package com.hot6.web.spring.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardDTO {
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
    // 유저 이름
    private String userName;
    // 유저 닉네임
    private String userNickName;
    //    문제 패키지 번호
    private Long quizList;
    //    문제 번호
    private Long quizNumber;
    //    신고 개수
    private Long boardReport;
    //    문제 패키지 번호 합
    private String quizListNumber;


    public void create(BoardDTO boardDTO) {
        this.boardNumber = boardDTO.getBoardNumber();
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardDate = boardDTO.getBoardDate();
        this.boardUpdateDate = boardDTO.getBoardUpdateDate();
        this.boardType = boardDTO.getBoardType();
        this.userNumber = boardDTO.getUserNumber();
        this.userName = boardDTO.getUserName();
        this.userNickName = boardDTO.getUserNickName();
        this.quizList = boardDTO.getQuizList();
        this.quizNumber = boardDTO.getQuizNumber();
        this.boardReport = boardDTO.getBoardReport();
    }
}