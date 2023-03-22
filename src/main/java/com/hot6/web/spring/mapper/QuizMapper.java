package com.hot6.web.spring.mapper;


import com.hot6.web.spring.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizMapper {
    //    문제 추가
    public void insert(QuizVO quizVO);

    //    문제 수정
    public void update(QuizVO quizVO);

    //    문제 조회
    public QuizVO select(Long quizNumber);

    //    문제 리스트 조회
    public List<QuizVO> selectList(Long quizList);

    //    문제 리스트 전체 조회
    public List<QuizVO> selectListAll(Criteria criteria);

    //    문제 전체 조회
    public List<QuizVO> selectAll(Criteria criteria);

    //    문제 삭제
    public void delete(Long quizNumber);

    //    문제 전체 갯수
    public int getTotal();


    // 오늘의 문제 등록
    public void insertAdm(QuizDTO quizDTO);

    // 오늘의 문제 전체 리스트
    public List<QuizDTO> selectAllToday(Criteria criteria);

    // 오늘의 문제 수
    public int getToday();

    // 오늘의 문제 디테일
    public QuizDTO selectTodayDetail(Long quizNumber);
    // 오늘의 문제 삭제
    public void deleteToday(Long quizNumber);
    // 대회 전체 리스트
    public List<QuizDTO> selectAllContest(Criteria criteria);

    public void updateToday(QuizDTO quizDTO);
    // 대회 전체 문제 수
    public int getTodayContest();

    //    문제 전체 리스트 갯수
    public int getListTotalAdm();

    //  문의글 상세보기
    public BoardDTO selectInquiry(Long boardNumber);

    // 문의글 이전글
    public BoardVO selectBefore(Long boardNumber);

    // 문의글 다음글
    public BoardVO selectAfter(Long boardNumber);

}