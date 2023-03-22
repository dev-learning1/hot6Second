package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.QuizVO;
import com.hot6.web.spring.repository.FileDAO;
import com.hot6.web.spring.repository.QuizDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("today") @Primary
public class TodayQuizService implements QuizService {
    private final QuizDAO quizDAO;
    private final FileDAO fileDAO;

    //    오늘의 문제 서비스
//    글 작성
    @Override
    public void register(QuizVO quizVO) { quizDAO.save(quizVO); }

    //    글 수정
    @Override
    public void modify(QuizVO quizVO) {
        quizDAO.setQuizDAO(quizVO);
    }

    //    글 삭제
    @Override
    public void remove(Long quizNumber) {
        quizDAO.remove(quizNumber);
    }

    //    글 조회
    @Override
    public QuizVO show(Long quizNumber) { return quizDAO.findById(quizNumber); }

    //    글 리스트 조회
    @Override
    public List<QuizVO> showList(Long quizList) { return quizDAO.findByList(quizList); }

    //    글 리스트 전체 조회
    @Override
    public List<QuizVO> showListAll(Criteria criteria) {
        return quizDAO.findByListAll(criteria);
    }

    //    글 전체 조회
    @Override
    public List<QuizVO> showAll(Criteria criteria) {
        return quizDAO.findByIdAll(criteria);
    }

    //    전체 개수
    @Override
    public int getTotal(){ return quizDAO.findCountAll(); }

    //    전체 리스트 개수
    @Override
    public int getListTotal(){ return quizDAO.findCountListAll(); }
}