package com.hot6.web.spring.mapper;


import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.QuizVO;
import com.hot6.web.spring.repository.QuizDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class QuizMapperTest {
    @Autowired
    private QuizMapper quizMapper;

    @Test
    public void selectAll(){
        Criteria criteria = new Criteria();
        criteria.create(1,10);
        List<QuizVO> quizVOList =  quizMapper.selectAll(criteria);
        for(QuizVO quizvo : quizVOList){
            log.info("Quiz theme type: " + quizvo.getQuizNumber().getClass().getName());
        }
    }

    @Test
    public void selectListAll(){
        Criteria criteria = new Criteria();
        criteria.create(1, 10);
        log.info("criteria: " + criteria);
        quizMapper.selectListAll(criteria, "0");
    }


    @Test
    public void delete(){
        quizMapper.delete(50L);
    }

    @Test
    public void getTotal(){
        log.info("total: "+quizMapper.getTotal());
    }

    @Test
    public void getListTotal(){
        log.info("countlistall: " + quizMapper.getListTotal("0"));
    }


}


















