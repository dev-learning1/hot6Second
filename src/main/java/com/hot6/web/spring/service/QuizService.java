package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.QuizVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {

    //    추가
    public void register(QuizVO quizVO);
    //    수정
    public void modify(QuizVO quizVO);
    //    삭제
    public void remove(Long quizNumber);
    //    문제 조회
    public QuizVO show(Long quizNumber);
    //    리스트 조회
    public List<QuizVO> showList(Long quizList);
    //    리스트 전체 조회
    public List<QuizVO> showListAll(Criteria criteria);
    //    전체 조회
    public List<QuizVO> showAll(Criteria criteria);
    //    전체 개수
    public int getTotal();
    //    전체 리스트 개수
    public int getListTotal();

}