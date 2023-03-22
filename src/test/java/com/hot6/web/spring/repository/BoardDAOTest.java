package com.hot6.web.spring.repository;


import com.hot6.web.spring.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTest {
    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void saveTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.create("새로작성한 제목", "새로작성한 내용", "0", 1L, 3L, 2L);
        boardDAO.save(boardVO);
    }
//
//    @Test
//    public void setBoardVOTest(){
//        BoardVO boardVO = boardDAO.findById(22L);
////        boardDTO.create(boardDAO.findById(1L));
//        boardVO.setBoardTitle("수정된 게시글 제목");
//        boardDAO.setBoardVO(boardVO);
//    }

    @Test
    public void findByIdTest(){
        log.info("board: " + boardDAO.findById(22L));
    }

//    @Test
//    public void findAllTest(){
//        boardDAO.findAll().stream().map(BoardVO::getBoardTitle).forEach(log::info);
//    }
}