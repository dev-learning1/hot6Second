package com.hot6.web.spring.repository;

import com.hot6.web.spring.domain.vo.ThumbVO;
import com.hot6.web.spring.mapper.ThumbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ThumbDAO {
    private final ThumbMapper thumbMapper;

    //    파일 추가
    public void saveThumb(ThumbVO thumbVO){
        thumbMapper.insertThumb(thumbVO);
    }
    //    파일 삭제
    public void removeThumb(Long userNumber){
        thumbMapper.deleteThumb(userNumber);
    }
    //    파일 조회
    public List<ThumbVO> findAllThumb(Long userNumber){
        return thumbMapper.selectAllThumb(userNumber);
    }
    //    지난 날 파일 조회
    public List<ThumbVO> findOldThumbs(){
        return thumbMapper.selectOldThumbs();
    }
}