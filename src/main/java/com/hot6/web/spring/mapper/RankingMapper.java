package com.hot6.web.spring.mapper;


import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.RankingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankingMapper {


    //    랭킹 전체 조회
    public List<RankingDTO> selectAll();
    public List<RankingDTO> selectAllBy(String userGrade);


    public List<RankingDTO> selectAllByC();
    public List<RankingDTO> selectAllByJ();
    public List<RankingDTO> selectAllByK();
}
