package com.hot6.web.spring.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ReplyVO {
//    댓글 번호
    @NonNull
    private Long replyNumber;
//  댓글 내용
    private String replyContent;
//    댓글 작성 날짜
    private String replyRegisterDate;
//    댓글 수정날짜
    private String replyUpdateDate;
//    게시글 번호
    @NonNull
    private Long boardNumber;
//  유저 번호
    @NonNull
    private Long userNumber;
    private String userNickname;



}
