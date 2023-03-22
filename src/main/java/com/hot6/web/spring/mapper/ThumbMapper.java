package com.hot6.web.spring.mapper;

import com.hot6.web.spring.domain.vo.FileVO;
import com.hot6.web.spring.domain.vo.ThumbVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThumbMapper {
    //    파일 추가
    public void insertThumb(ThumbVO thumbVO);
    //    파일 삭제
    public void deleteThumb(Long userNumber);
    //    파일 조회
    public List<ThumbVO> selectAllThumb(Long userNumber);
    //    지난 날 파일 조회
    public List<ThumbVO> selectOldThumbs();
}