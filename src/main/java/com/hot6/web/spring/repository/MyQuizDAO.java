package com.hot6.web.spring.repository;

import com.hot6.web.spring.domain.vo.CriteriaDTO;
import com.hot6.web.spring.domain.vo.MyQuizVO;
import com.hot6.web.spring.domain.vo.QuizDTO;
import com.hot6.web.spring.domain.vo.QuizVO;
import com.hot6.web.spring.mapper.MyQuizMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyQuizDAO {
    private final MyQuizMapper myQuizMapper;
    //  댓글 추가
//    public void save(MyQuizDTO myQuizDTO){
//        myQuizMapper.insert(myQuizDTO);
//    }
    public void save(MyQuizVO myQuizVO){
        myQuizMapper.insert(myQuizVO);
    }
    //   댓글 수정
//    public void setMyQuiz(MyQuizDTO myQuizDTO){
//        myQuizMapper.update(myQuizDTO);
//    }
    public void setMyQuiz(Long quizNumber , Long userNumber){
        myQuizMapper.update(quizNumber ,userNumber);
    }


//    조회
//    public myQuizDTO findById(Long myQuizNumber){
//        return myQuizMapper.select(myQuizNumber);
//    }

//    전체 정답 조회
//    public List<myQuizDTO> findAllOK(Long userNumber){
//        return myQuizMapper.selectAllOK(userNumber);
//    }

//    전체 오답 조회
//    public List<myQuizDTO> findAllNO(Long userNumber){
//        return myQuizMapper.selectAllNO(userNumber);
//    }









    public List<QuizDTO> findUserQuizOk(CriteriaDTO criteriaDTO){
        return myQuizMapper.selectUserQuizOk(criteriaDTO);
    }
    public int getUserQuizOkTotal(Long userNumber){
        return myQuizMapper.countQuizOkTotal(userNumber);
    }

    public List<QuizDTO> findUserQuizNo(CriteriaDTO criteriaDTO){
        return myQuizMapper.selectUserQuizNo(criteriaDTO);
    }
    public int getUserQuizNoTotal(Long userNumber){
        return myQuizMapper.countQuizNoTotal(userNumber);
    }
}




















