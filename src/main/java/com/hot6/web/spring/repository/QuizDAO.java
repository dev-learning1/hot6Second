package com.hot6.web.spring.repository;

import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.QuizDTO;
import com.hot6.web.spring.domain.vo.QuizVO;
import com.hot6.web.spring.mapper.QuizMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuizDAO {
    private final QuizMapper quizMapper;

    // 추가 save
    public void save(QuizVO quizVO){
        quizMapper.insert(quizVO);
    }

    // 수정 set
    public void setQuizDAO(QuizVO quizVO){
        quizMapper.update(quizVO);
    }

    // 삭제 remove
    public void remove(Long quizNumber){
        quizMapper.delete(quizNumber);
    }

    // 조회 findById
    public QuizVO findById(Long quizNumber){
        return quizMapper.select(quizNumber);
    }

    // 조회 findByList
    public List<QuizVO> findByList(Long quizList){
        return quizMapper.selectList(quizList);
    }

    // 오늘의 문제 전체 조회 findByListAll
    public List<QuizVO> findByListAll(Criteria criteria, String quizTheme){ return quizMapper.selectListAll(criteria, quizTheme); }

    // 대회 전체 조회 findByListAll
    public List<QuizVO> findByContestListAll(Criteria criteria){ return quizMapper.selectContestListAll(criteria); }

    // 전체 조회 findByIdAll
    public List<QuizVO> findByIdAll(Criteria criteria){ return quizMapper.selectAll(criteria); }

    // 개수 findCountAll
    public int findCountAll(){
        return quizMapper.getTotal();
    }

    // 리스트 개수 findCountListAll
    public int findCountListAll(String quizTheme){
        return quizMapper.getListTotal(quizTheme);
    }

    // Admin 오늘의 문제 insert
    public void saveToday(QuizDTO quizDTO){ quizMapper.insertAdm(quizDTO); }
    public void updateToday(QuizDTO quizDTO){quizMapper.updateToday(quizDTO);}
    // Admin 오늘의 문제 리스트
    public List<QuizDTO> findAll(Criteria criteria) { return quizMapper.selectAllToday(criteria); }
    // Admin 오늘의 문제 개수
    public int getToday(){ return quizMapper.getToday(); }
    // Admin 오늘의 문제 삭세
    public void deleteToday(Long quizNumber){ quizMapper.deleteToday(quizNumber);}
    // Admin 대회 문제 리스트
    public List<QuizDTO> findAllContest(Criteria criteria){ return quizMapper.selectAllContest(criteria); }

    // Admin 대회 개수
    public int getTodayContest(){ return quizMapper.getTodayContest(); }
    // 개수 findCountListAll


    // Admin 오늘의 문제 디테일
    public QuizDTO findTodayDetail(Long quizNumber){return quizMapper.selectTodayDetail(quizNumber);}

}

















