package com.hot6.web.spring.service;

import com.hot6.web.spring.domain.vo.ThumbVO;
import com.hot6.web.spring.repository.ThumbDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThumbService {
    private final ThumbDAO thumbDAO;

    public List<ThumbVO> showOldThumbs(){
        return thumbDAO.findOldThumbs();
    }
}
