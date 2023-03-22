package com.hot6.web.spring.repository;

import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.mapper.RankingMapper;
import com.hot6.web.spring.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    public void save(ReplyVO replyVO) {
        replyMapper.insert(replyVO);
    }

    public List<ReplyVO> findAll(Long boardNumber, Criteria criteria) {
        return replyMapper.selectAll(boardNumber, criteria);
    }

    public void setReplyVO(ReplyVO replyVO) {
        replyMapper.update(replyVO);
    }

    public void remove(Long replyNumber) {
        replyMapper.delete(replyNumber);
    }

    public ReplyVO findById(Long replyNumber) {
        return replyMapper.select(replyNumber);
    }

    public int count(Long boardNumber) {
        return replyMapper.getTotal(boardNumber);
    }

    // Admin 문의글 댓글 조회
    public List<InReplyVO> findAllInReply(Long boardNumber){
        return replyMapper.selectAllInReply(boardNumber);
    }

    // Admin 댓글 전체 개수
    public int getTotal(Long boardNumber){
        return replyMapper.getTotalAdm(boardNumber);
    }
    // Admin 문의글 댓글 추가
    public void addInReply(InReplyVO inReplyVO){ replyMapper.insertInReply(inReplyVO);}

}





















