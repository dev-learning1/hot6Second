package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.BoardDTO;
import com.hot6.web.spring.domain.vo.BoardVO;
import com.hot6.web.spring.domain.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    //    추가
    public void register(BoardVO boardVO);
    //    수정
    public void modify(BoardVO boardVO);
    //    삭제
    public void remove(Long boardNumber);
    //    조회
    public BoardVO show(Long boardNumber);
    //    전체 조회
    public List<BoardVO> showAll();
//    전체 개수
//    public int getTotal(Long boardNumber);

}