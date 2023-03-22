package com.hot6.web.spring.service;


import com.hot6.web.spring.domain.vo.FileVO;
import com.hot6.web.spring.domain.vo.ThumbVO;
import com.hot6.web.spring.domain.vo.UserDTO;
import com.hot6.web.spring.domain.vo.UserVO;
import com.hot6.web.spring.repository.FileDAO;
import com.hot6.web.spring.repository.ThumbDAO;
import com.hot6.web.spring.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final ThumbDAO thumbDAO;
    private final UserDTO userDTO;

    // 회원가입
    // 일반
    public void saveUser(UserVO userVO){
        userDAO.saveUser(userVO);
    }
    // 기관
    public void saveCompany(UserVO userVO){
        userDAO.saveCompany(userVO);
    }


    // 내 정보 수정(유저 수정)

    // 내 정보 보기(유저 조회)

    // 로그인 시 아이디 조회
    public int checkUser(UserVO userVO){
        return userDAO.checkUser(userVO);
    }

    // 유저 number 가쟈오기
    public long getUserNumber(String userEmail){return userDAO.getUserNumber(userEmail);}

    // 정보 수정
    @Transactional(rollbackFor = Exception.class)
    public void modifyUser(UserDTO userDTO){
        System.out.println("7");
        System.out.println(userDTO);
        userDAO.modifyUser(userDTO);
        System.out.println("9");
        System.out.println("userDTO: " + userDTO);
//        thumbDAO.removeThumb(userDTO.getUserNumber());// (long) 15
//        System.out.println("444444");
        System.out.println("userDTO.getThumbs: " + userDTO.getThumbs());
        List<ThumbVO> thumbs = userDTO.getThumbs();
        System.out.println(thumbs);
        Optional.ofNullable(thumbs).ifPresent(thumbList -> {
            thumbList.forEach(thumb -> {
                System.out.println("10");
                thumb.setUserNumber(userDTO.getUserNumber());
                System.out.println("11");
                thumbDAO.saveThumb(thumb);
            });
        });
    }

    // 특정 유저 정보 가져오기
    public UserVO getUserInfo(String userEmail){return userDAO.getUserInfo(userEmail);}

    public UserDTO showUser(Long userNumber){
        UserDTO userDTO = new UserDTO();
        userDTO.create(userDAO.findByNumber(userNumber));
        userDTO.setThumbs(thumbDAO.findAllThumb(userNumber));
        return userDTO;
    }

    // 탈퇴
    public void removeUser(Long userNumber){userDAO.remove(userNumber);}
}