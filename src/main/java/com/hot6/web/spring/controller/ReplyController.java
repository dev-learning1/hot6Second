package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.ReplyDTO;
import com.hot6.web.spring.domain.vo.ReplyVO;
import com.hot6.web.spring.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply/*")
public class ReplyController {
    private final ReplyService replyService;

    //    추가
    @PostMapping("/new")
    public String write(@RequestBody ReplyVO replyVO){
        replyService.register(replyVO);
        return "write success";
    }

    //    전체 조회
    @GetMapping("/list/{boardNumber}/{page}")
    public ReplyDTO list(@PathVariable("boardNumber") Long boardNumber, @PathVariable int page){
        return new ReplyDTO(replyService.showAll(boardNumber, new Criteria().create(page, 10)), replyService.count(boardNumber));
    }

    @PostMapping("/modify")
    public void modify(@RequestBody ReplyVO replyVO){
//        Optional은 JDK8부터 지원되는 검증 클래스이며, ofNullable(Object)로 사용한다.
//        ifPresent()를 사용하여 null 여부 검사가 가능하며, null이 아니라면 기존 Object 객체를 그대로 사용한다.
//        orElse를 사용하면 null일 경우 대체할 객체를 작성할 수 있다.
//        replyVO.setReplyWriter(Optional.ofNullable(replyVO.getReplyWriter()).orElse(replyService.show(replyVO.getReplyNumber()).getReplyWriter()));
        replyService.modify(replyVO);
    }

    //    댓글 삭제
    @DeleteMapping("/{replyNumber}")
    public void remove(@PathVariable Long replyNumber){
        replyService.remove(replyNumber);
    }

    //    댓글 1개 조회
    @GetMapping("/{replyNumber}")
    public ReplyVO show(@PathVariable Long replyNumber){
        return replyService.show(replyNumber);
    }

    // 댓글 수 조회
    @GetMapping("/count")
    @ResponseBody
    public int count(@RequestParam Long boardNumber){
        return replyService.count(boardNumber);
    }
}
