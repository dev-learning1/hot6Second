package com.hot6.web.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    //    브라우저에서 URL을 요청한 것과 같은 환경을 구성해준다.
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void bordList() throws Exception {
        log.info("boards: " + mockMvc.perform(MockMvcRequestBuilders.get("/board/boardlist")).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void bordWrite() throws Exception{
        log.info("flash map: " + mockMvc.perform(MockMvcRequestBuilders.get("/board/boardWrite")
                .param("boardTitle", "새로 작성한 글 제목")
                .param("boardContent", "새로잓어한 글 내용")).andReturn().getFlashMap());
    }

    @Test
    void boardDetail() throws Exception {
        log.info("model map: " + mockMvc.perform(MockMvcRequestBuilders.get("/board/boardDetail").param("boardNumber", "22"))
                .andReturn().getModelAndView().getModelMap());
    }

    @Test
    void boardUpdate() throws Exception{
        log.info("model map: " + mockMvc.perform(MockMvcRequestBuilders.post("/board/boardUpdate")
                .param("boardNumber", "22")
                .param("boardTitle", "수정된 게시글 제목")
                .param("boardContent", "수정된 게시글 내용")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void boardDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/board/boardDelete")
                .param("boardNumber", "32")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}








