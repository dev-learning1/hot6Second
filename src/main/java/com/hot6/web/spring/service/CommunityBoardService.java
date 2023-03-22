package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.BoardDTO;
import com.hot6.web.spring.domain.vo.BoardVO;
import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.repository.BoardDAO;
import com.hot6.web.spring.repository.FileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor @Qualifier("community") @Primary
public class CommunityBoardService {
    private final BoardDAO boardDAO;
    private final FileDAO fileDAO;


    public void register(BoardVO boardVO) {
        boardDAO.save(boardVO);
    }



    public void modify(BoardDTO boardDTO) {
        boardDAO.setBoardVO(boardDTO);
    }


    @Transactional(rollbackFor = Exception.class)
    public void remove(Long boardNumber) {
        boardDAO.remove(boardNumber);
    }



    public BoardDTO show(Long boardNumber) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.create(boardDAO.findById(boardNumber));
        return boardDTO;
    }

    public List<BoardVO> showAllMain() {
        return boardDAO.findAllMain();
    }


    public List<BoardDTO> showAllBy(String boardType) {
        return boardDAO.findAllBy(boardType);
    }


    public List<BoardDTO> showAll(Criteria criteria) {
        return boardDAO.findAll(criteria);
    }

/*    @Override
    public List<BoardVO> showAllBy(Long boardType) {
        return boardDAO.findAllBy(boardType);
    }*/

    public int getTotal() {
    return boardDAO.findCountAll();
}

}
