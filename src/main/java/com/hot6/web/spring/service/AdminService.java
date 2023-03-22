package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

//    답변 작성

//    게시글 삭제

//    유저 전체 조회(showUser)

//    문제 조회

    // 오늘의 문제 등록
    public void registerToday(QuizDTO quizDTO);

    // 오늘의 문제 전체 조회
    public List<QuizDTO> showAllToday(Criteria criteria);

    // 오늘의 문제 전체 수
    public int getToday();

    // 오늘의 문제 디테일
    public QuizDTO showTodayDetail(Long quizNumber);
    // 오늘의 문제 삭제
    public void deleteToday(Long quizNumber);

    // 대회 전체 리스트
    public List<QuizDTO> showAllContest(Criteria criteria);

    public void updateToday(QuizDTO quizDTO);
    // 대회 전체 수
    public int getTodayContest();


//    //    전체 조회
//    public List<BoardVO> findAll();

    // 유저 전체 조회
    public List<UserVO> showAllUser(Criteria criteria);

    // 유저 상세 조회
    public UserVO showUser(Long userNumber);

    // 유저 삭제
    public void remove(Long userNumber);

    // 유저 전체 개수
    public int getTotal();
    // 작성게시글 상세조회
    public BoardDTO admBoardDetail(Long boardNumber);

    // 작성글 이전 글
    public BoardVO beforeBoardInquiry(Long boardNumber);
    // 작성글 다음 글
    public BoardVO afterBoardInquiry(Long boardNumber);
    // 문의글 전체 조회
    public List<BoardVO> showAllInquiry(Criteria criteria);

    // 문의글 전체 개수
    public int getInquiryTotal();

    // 문의글 상세조회
    public BoardDTO showInquiry(Long boardNumber);

    // 문의글 댓글 조회
    public List<InReplyVO> showAllInReply(Long boardNumber);

    // 문의글 댓글 전체 개수
    public int getTotalReply(Long boardNumber);
    // 문의글 댓글 추가
    public void addInReply(InReplyVO inReplyVO);
    // 문의글 이전 글
    public BoardVO beforeInquiry(Long boardNumber);
    // 문의글 다음 글
    public BoardVO afterInquiry(Long boardNumber);
    // 작성 게시글 전체 보기
    public List<BoardDTO> showAllBoards(Criteria criteria);
    // 작성 게시글 전체 개수
    public int getBoardTotal();

    public List<BoardDTO> selectAllBoardReport(Criteria criteria);
    public void deleteAdmBoard(Long boardNumber);
}