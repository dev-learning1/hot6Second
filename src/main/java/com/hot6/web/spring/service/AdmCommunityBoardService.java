package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("Admcommunity") @Primary
public class AdmCommunityBoardService implements AdminService {
    private final BoardDAO boardDAO;
    private final UserDAO userDAO;
    private final FileDAO fileDAO;
    private final QuizDAO quizDAO;
    private final ReplyDAO replyDAO;

    // 유저 전체 조회
    public List<UserVO> showAllUser(Criteria criteria){ return userDAO.findAllUser(criteria);}

    // 유저 상세 조회
    public UserVO showUser(Long userNumber){ return userDAO.findUser(userNumber); }

    // 유저 삭제
    public void remove(Long userNumber){ userDAO.remove(userNumber);}

    // 전체 유저 카운트
    public int getTotal(){ return userDAO.getTotal();}

    @Override
    public void updateToday(QuizDTO quizDTO) {
        quizDAO.updateToday(quizDTO);
    }

    // 오늘의 문제 추가
    @Override
    public void registerToday(QuizDTO quizDTO) {
        quizDAO.saveToday(quizDTO);
    }

    // 오늘의 문제 리스트 전체보기
    @Override
    public List<QuizDTO> showAllToday(Criteria criteria) { return quizDAO.findAll(criteria); }

    // 오늘의 문제 전체 개수
    @Override
    public int getToday() { return quizDAO.getToday();}
    // 오늘의 문제 디테일
    @Override
    public QuizDTO showTodayDetail(Long quizNumber) { return quizDAO.findTodayDetail(quizNumber);}
    // 오늘의 문제 삭제
    @Override
    public void deleteToday(Long quizNumber) { quizDAO.deleteToday(quizNumber);}
    // 대회 문제 리스트 전체보기
    @Override
    public List<QuizDTO> showAllContest(Criteria criteria) { return quizDAO.findAllContest(criteria); }
    // 대회 문제 전체 개수
    @Override
    public int getTodayContest() { return quizDAO.getTodayContest(); }

    // 작성 게시글 전체 조회
//    @Override
//    public List<BoardVO> findAll(Criteria criteria) { return null;}

    // 작성게시글 상세보기
    @Override
    public BoardDTO admBoardDetail(Long boardNumber) { return boardDAO.admBoardDetail(boardNumber);}

    // 작성글 이전글글
    @Override
    public BoardVO beforeBoardInquiry(Long boardNumber) { return boardDAO.beforeBoard(boardNumber);}
    // 작성글 다음 글
    @Override
    public BoardVO afterBoardInquiry(Long boardNumber) { return boardDAO.afterBoard(boardNumber); }

    // 문의글 전체 조회
    @Override
    public List<BoardVO> showAllInquiry(Criteria criteria) {
        return boardDAO.findAllInquiry(criteria);
    }

    // 문의글 상세 조회
    @Override
    public BoardDTO showInquiry(Long boardNumber) { return boardDAO.findInquiry(boardNumber);}

    // 문의글 전체 카운트
    @Override
    public int getInquiryTotal() {
        return boardDAO.inquiryGetTotal();
    }

    // 문의글 댓글 전체 조회
    @Override
    public List<InReplyVO> showAllInReply(Long boardNumber) { return replyDAO.findAllInReply(boardNumber);}

    // 문의글 댓글 개수
    @Override
    public int getTotalReply(Long boardNumber) { return replyDAO.getTotal(boardNumber); }
    // 문의글 댓글 추가
    @Override
    public void addInReply(InReplyVO inReplyVO) { replyDAO.addInReply(inReplyVO); }
    // 문의글 이전글글
    @Override
    public BoardVO beforeInquiry(Long boardNumber) { return boardDAO.beforeInquiry(boardNumber); }
    // 문의글 다음 글
    @Override
    public BoardVO afterInquiry(Long boardNumber) { return boardDAO.afterInquiry(boardNumber); }
    // 작성게시글 전체 조회
    @Override
    public List<BoardDTO> showAllBoards(Criteria criteria) { return boardDAO.findAllBoards(criteria); }
// 작성 게시글 전체 개수

    @Override
    public int getBoardTotal() { return boardDAO.getBoardTotal(); }

    @Override
    public List<BoardDTO> selectAllBoardReport(Criteria criteria) { return boardDAO.selectAllBoardReport(criteria);}

    @Override
    public void deleteAdmBoard(Long boardNumber) { boardDAO.deleteAdmBoard(boardNumber); }
}