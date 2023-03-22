package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.QuizVO;
import com.hot6.web.spring.service.ContestQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contest/*")
public class ContestWriteController {
    private final ContestQuizService contestQuizService;

//    등록
    @PostMapping("/plus")
    public String write(@RequestBody QuizVO quizVO){
        contestQuizService.register(quizVO);
        return "write success";
    }



    //    전체 조회
    @GetMapping("/{quizList}")
    public List<QuizVO> list(@PathVariable("quizList") Long quizList){
        return contestQuizService.showList(quizList);
    }

    //    댓글 1개 조회
    @GetMapping("/{quizNumber}")
    public QuizVO show(@PathVariable Long quizNumber){
        return contestQuizService.show(quizNumber);
    }
}

