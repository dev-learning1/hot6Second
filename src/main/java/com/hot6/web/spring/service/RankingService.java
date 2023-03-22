package com.hot6.web.spring.service;

import com.hot6.web.spring.domain.vo.RankingDTO;

import com.hot6.web.spring.repository.RankingDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final RankingDAO rankingDAO;


    // 내 랭킹 조회
    public List<RankingDTO> showAll() {
        return rankingDAO.findAll();
    }

    public List<RankingDTO> showAllBy(String userGrade) {
        return rankingDAO.findAllBy(userGrade);
    }



}
