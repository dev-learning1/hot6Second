package com.hot6.web.spring.service;

import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.repository.MyQuizDAO;
import com.hot6.web.spring.repository.QuizDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyQuizService {
    private final MyQuizDAO myQuizDAO;

    //    추가
    public void register(MyQuizVO myQuizVO) { myQuizDAO.save(myQuizVO); }
    //    수정
    public void modify(Long quizNumber , Long userNumber) { myQuizDAO.setMyQuiz(quizNumber , userNumber); };




    public List<QuizDTO> findUserQuizOk(CriteriaDTO criteriaDTO){return myQuizDAO.findUserQuizOk(criteriaDTO);}
    public int getUserQuizOkTotal(Long userNumber){return myQuizDAO.getUserQuizOkTotal(userNumber);}

    public List<QuizDTO> findUserQuizNo(CriteriaDTO criteriaDTO){return myQuizDAO.findUserQuizNo(criteriaDTO);}
    public int getUserQuizNoTotal(Long userNumber){return myQuizDAO.getUserQuizNoTotal(userNumber);}
}