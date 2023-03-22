package com.hot6.web.spring.repository;


import com.hot6.web.spring.domain.vo.BoardVO;
import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.RankingDTO;
import com.hot6.web.spring.mapper.RankingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RankingDAO {
    private final RankingMapper rankingMapper;

// 조회 findById

    //    전체 조회
    public List<RankingDTO> findAll() {
        return rankingMapper.selectAll();
    }

    public List<RankingDTO> findAllBy(String userGrade) {
        return rankingMapper.selectAllBy(userGrade);
    }



// 개수 findCountAll
}





















