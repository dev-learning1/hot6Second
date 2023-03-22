package com.hot6.web.spring.mapper;

//<<<<<<< HEAD
//import com.example.app.domain.vo.BoardDTO;
//import com.example.app.domain.vo.BoardVO;
//import com.example.app.domain.vo.Criteria;
//=======

import com.hot6.web.spring.domain.vo.BoardDTO;
import com.hot6.web.spring.domain.vo.BoardVO;
import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.CriteriaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //    추가
    public void insert(BoardVO boardVO);
    //    수정
    public void update(BoardDTO boardDTO);
    //    삭제
    public void delete(Long boardNumber);
    //    조회
    public BoardDTO select(Long boardNumber);
    public BoardVO selectAdm(Long boardNumber);
    //    전체 조회
    public List<BoardDTO> selectAll(Criteria criteria);
    public List<BoardVO> selectAllMain();
    // 전체 조건 조회
    public List<BoardDTO> selectAllBy(String boardType);
    //    전체 개수
    public int getTotal();

    //  문의글 전체 개수
    public int getInquiryTotal();

    //  문의글 전체 조회
    public List<BoardVO> selectAllInquiry(Criteria criteria);

    //  문의글 상세보기
    public BoardDTO selectInquiry(Long boardNumber);

    // 문의글 이전글
    public BoardVO selectBefore(Long boardNumber);

    // 문의글 다음글
    public BoardVO selectAfter(Long boardNumber);

    // 작성 게시글 전체보기
    public List<BoardDTO> selectAllBoard(Criteria criteria);

    // 작성 게시글 수
    public int getBoardTotal();
    //    특정 유저 게시글 전체 가져오기
    public List<BoardVO> getUserInquiry(String userEmail);
    //    전체 조회
    public List<BoardDTO> selectUserInquiryAll(CriteriaDTO criteriaDTO);
    //    전체 개수
    public int getUserInquiryTotal(Long userNumber);
    // 문의하기
    public void userSendInquiry(BoardVO boardVO);
    // 문의글 개수 가쟈오기
    public int getInquiryCount(Long userNumber);
    public int getInquiryWaitCount(Long userNumber);
    public List<BoardDTO> selectAllBoardReport(Criteria criteria);
    // admin 작성게시글 상세보기
    public BoardDTO AdmBoardDetail(Long boardNumber);
    public void deleteAdmBoard(Long boardNumber);
    // 작성게시글 이전글
    public BoardVO selectBoardBefore(Long boardNumber);

    // 작성게시글 다음글
    public BoardVO selectBoardAfter(Long boardNumber);
}