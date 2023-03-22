package com.hot6.web.spring.repository;


import com.hot6.web.spring.domain.vo.BoardDTO;
import com.hot6.web.spring.domain.vo.BoardVO;
import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.CriteriaDTO;
import com.hot6.web.spring.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    //    추가
    public void save(BoardVO boardVO){
        boardMapper.insert(boardVO);
    }
    //    수정
    public void setBoardVO(BoardDTO boardDTO){
        boardMapper.update(boardDTO);
    }
    //    삭제
    public void remove(Long boardNumber){
        boardMapper.delete(boardNumber);
    }
    //    조회
    public BoardDTO findById(Long boardNumber){
        return boardMapper.select(boardNumber);
    }
    //    조회
    public BoardVO findByIdAdm(Long boardNumber){
        return boardMapper.selectAdm(boardNumber);
    }
    //    전체 조회
    public List<BoardDTO> findAll(Criteria criteria){
        return boardMapper.selectAll(criteria);
    }

    //    전체 조회
    public List<BoardVO> findAllMain(){
        return boardMapper.selectAllMain();
    }

    // 전체 조건 조회(타입)
    public List<BoardDTO> findAllBy(String boardType){ return boardMapper.selectAllBy(boardType);}
    //    전체 개수
    public int findCountAll(){
        return boardMapper.getTotal();
    }
    // admin 문의 전체 조회
    public List<BoardVO> findAllInquiry(Criteria criteria) { return boardMapper.selectAllInquiry(criteria); }

    // admin 문의 전체 개수
    public int inquiryGetTotal(){return boardMapper.getInquiryTotal();}

    // admin 문의 상세조회
    public BoardDTO findInquiry(Long boardNumber) { return boardMapper.selectInquiry(boardNumber); }

    // Admin 문의 이전글
    public BoardVO beforeInquiry(Long boardNumber) { return boardMapper.selectBefore(boardNumber); }

    // Admin 문의 다음글
    public BoardVO afterInquiry(Long boardNumber){ return boardMapper.selectAfter(boardNumber); }

    // Admin 작성 게시글 전체보기
    public List<BoardDTO> findAllBoards(Criteria criteria){ return boardMapper.selectAllBoard(criteria);}
    // Admin 작성 게시글 개수
    public int getBoardTotal(){return boardMapper.getBoardTotal();}

    //    ======================마이페이지 부분======================
//    특정 유저 게시글 전체 가져오기
    public List<BoardVO> findUserInquiry(String userEmail){return boardMapper.getUserInquiry(userEmail);}
    //    전체 조회
    public List<BoardDTO> findUserInquiryAll(CriteriaDTO criteriaDTO){
        return boardMapper.selectUserInquiryAll(criteriaDTO);
    }
    //    전체 개수
    public int findCountUserInquiryAll(Long userNumber){
        return boardMapper.getUserInquiryTotal(userNumber);
    }
    // 문의하기
    public void sendInquiry(BoardVO boardVO){boardMapper.userSendInquiry(boardVO);}

    // 문의글 개수 가져오기
    public int getInquiryCount(Long userNumber){return boardMapper.getInquiryCount(userNumber);}
    public int getInquiryWaitCount(Long userNumber){return boardMapper.getInquiryWaitCount(userNumber);}
    // Admin 문의 이전글
    public BoardVO beforeBoard(Long boardNumber) { return boardMapper.selectBoardBefore(boardNumber); }

    // Admin 문의 다음글
    public BoardVO afterBoard(Long boardNumber){ return boardMapper.selectBoardAfter(boardNumber); }
    public void deleteAdmBoard(Long boardNumber){ boardMapper.deleteAdmBoard(boardNumber);}
    // admin 작성 게시글 상세보기
    public BoardDTO admBoardDetail(Long boardNumber){ return  boardMapper.AdmBoardDetail(boardNumber);}
    public List<BoardDTO> selectAllBoardReport(Criteria criteria){ return boardMapper.selectAllBoardReport(criteria); }
}
