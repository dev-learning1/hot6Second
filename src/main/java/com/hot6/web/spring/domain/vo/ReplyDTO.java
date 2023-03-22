package com.hot6.web.spring.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public class ReplyDTO {

    private List<ReplyVO> replies;
    private int replyCount;
}

