package com.hot6.web.spring.repository;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QuizDAOTest {
    @Autowired
    private QuizDAO quizDAO;

    @Test
    public void findCountListAll(){
        log.info("countlistall: " + quizDAO.findCountListAll("1"));
    }


}












