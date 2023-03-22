package com.hot6.web.spring.mapper;


import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.InReplyVO;
import com.hot6.web.spring.domain.vo.ReplyDTO;
import com.hot6.web.spring.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public void insert(ReplyVO replyVO);
    public List<ReplyVO> selectAll(@Param("boardNumber") Long boardNumber, @Param("criteria") Criteria criteria);
    public void update(ReplyVO replyVO);
    public void delete(Long replyNumber);
    public ReplyVO select(Long replyNumber);
    public int getTotal(Long boardNumber);
    public int getTotalAdm(Long boardNumber);

    //    Admin 문의글 전체 댓글 조회
    public List<InReplyVO> selectAllInReply(Long boardNumber);


    // Admin 문의 댓글 추가
    public InReplyVO insertInquiry(Long quizNumber);
    // Admin 문의글 댓글 추가
    public void insertInReply(InReplyVO inReplyVO);
}
