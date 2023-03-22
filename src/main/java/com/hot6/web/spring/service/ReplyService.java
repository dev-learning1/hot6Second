package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.BoardDTO;
import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.ReplyDTO;
import com.hot6.web.spring.domain.vo.ReplyVO;
import com.hot6.web.spring.repository.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyDAO replyDAO;

    public void register(ReplyVO replyVO){
        replyDAO.save(replyVO);
    }

    public List<ReplyVO> showAll(Long boardNumber, Criteria criteria){
        return replyDAO.findAll(boardNumber, criteria);
    }

    public void modify(ReplyVO replyVO){
        replyDAO.setReplyVO(replyVO);
    }

    public void remove(Long replyNumber){
        replyDAO.remove(replyNumber);
    }

    public ReplyVO show(Long replyNumber){
        return replyDAO.findById(replyNumber);
    }

    public int count(Long boardNumber){
        return replyDAO.count(boardNumber);
    }
}
