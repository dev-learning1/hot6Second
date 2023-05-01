package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.BoardVO;
import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.QuizDTO;
import com.hot6.web.spring.domain.vo.QuizVO;
import com.hot6.web.spring.repository.FileDAO;
import com.hot6.web.spring.repository.QuizDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("contest")
public class ContestQuizService implements QuizService {
    private final QuizDAO quizDAO;
    private final FileDAO fileDAO;

    //    대회 문제 서비스
//    대회글 작성
    @Override
    public void register(QuizVO quizVO) { quizDAO.save(quizVO); }

    //    대회 수정
    @Override
    public void modify(QuizVO quizVO) { quizDAO.setQuizDAO(quizVO); }

    //    대회글 삭제
    @Override
    public void remove(Long quizNumber) {
        quizDAO.remove(quizNumber);
    }

    //    대회글 조회
    @Override
    public QuizVO show(Long quizNumber) { return quizDAO.findById(quizNumber); }

    //    대회글 리스트 조회
    @Override
    public List<QuizDTO> showList(Long quizList) { return quizDAO.findByList(quizList); }

    //    오늘의 문제 리스트 전체 조회
    @Override
    public List<QuizVO> showListAll(Criteria criteria, String quizTheme){
        return quizDAO.findByListAll(criteria, quizTheme);
    }

    //    대회글 리스트 전체 조회
    //    진행 전, 진행 중은 QUIZ_FINISH_DATE 오름차순으로
    //    종료는 QUIZ_FINISH_DATE 내림차순으로 정렬
    @Override
    public List<QuizVO> showContestListAll(Criteria criteria){
        return quizDAO.findByContestListAll(criteria);
    }

    //    대회글 전체 조회
    @Override
    public List<QuizVO> showAll(Criteria criteria) {
        return quizDAO.findByIdAll(criteria);
    }

    //    전체 개수
    @Override
    public int getTotal(){ return quizDAO.findCountAll(); }

    //    전체 리스트 개수
    @Override
    public int getListTotal(String quizTheme){ return quizDAO.findCountListAll(quizTheme); }

    // 최신 리스트 번호 조회
    public Long getRecentListNumber(){
        return quizDAO.findRecentListNumber();
    }
}