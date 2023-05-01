package com.hot6.web.spring.mapper;


import com.hot6.web.spring.domain.vo.Criteria;
import com.hot6.web.spring.domain.vo.UserDTO;
import com.hot6.web.spring.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //    추가
    // 일반
    public void insertUser(UserVO userVO);

    // 기관
    public void insertCompany(UserVO userVO);

//    수정
//    public void update(UserVO userVO);


//    조회
//    public UserVO select(Long userNumber);

//    전체 조회
//    public List<UserVO> selectAll(Criteria criteria);

    // 로그인 시 아이디 조회
    public int selectUser(UserVO userVO);

    // 유저 number 가져오기
    public long selectUserNumber(String userEmail);

    // 유저 type 가져오기
    public String selectUserType(String userEmail);

    // 유저 nickname 가져오기
    public String selectUserNickname(String userEmail);

    // 정보 수정
    public void updateUser(UserDTO userDTO);

    // 유저 점수 정보 수정
    public void updateUserPoint(UserDTO userDTO);

    public UserVO getUserInfos(Long userNumber);

    // 특정 유저 정보 가져오기
    public UserVO getInfo(String userEmail);

    // admin 유저 전체 조회
    public List<UserVO> selectAllUser(Criteria criteria);

    // admin 유저 상세 조회
    public UserVO selectUserAdm(Long userNumber);

    // admin 유저 삭제
    public void deleteUser(Long userNumber);

    // admin 유저 전체 카운트
    public int getTotal();
}