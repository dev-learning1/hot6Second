package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.*;
import com.hot6.web.spring.repository.BoardDAO;
import com.hot6.web.spring.repository.FileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InquiryBoardService implements BoardService {
    private final BoardDAO boardDAO;
    private final FileDAO fileDAO;



    //    추가
    public void register(BoardVO boardVO){};
    //    수정
    public void modify(BoardVO boardVO){};
    //    삭제
    public void remove(Long boardNumber){};
    //    조회
    public BoardVO show(Long boardNumber){return null;};
    //    전체 조회
    public List<BoardVO> showAll(){return null;};







    //    ======================마이페이지 부분======================
//    특정 유저 게시글 전체 가져오기
    public List<BoardVO> findUserInquiry(String userEmail){return boardDAO.findUserInquiry(userEmail);}
    //    전체 조회
    public List<BoardDTO> showUserInquiryAll(CriteriaDTO criteriaDTO) {
        return boardDAO.findUserInquiryAll(criteriaDTO);
    }
    public int getUserInquiryTotal(Long userNumber) {
        return boardDAO.findCountUserInquiryAll(userNumber);
    }
    //  문의하기
    public void sendInquiry(BoardVO boardVO){boardDAO.sendInquiry(boardVO);}

    // 문의 개수 가져오기
    public int showInquiryCount(Long userNumber){return boardDAO.getInquiryCount(userNumber);}
    public int showInquiryWaitCount(Long userNumber){return (boardDAO.getInquiryCount(userNumber) - boardDAO.getInquiryWaitCount(userNumber));}






}