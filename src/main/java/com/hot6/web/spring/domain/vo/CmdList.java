package com.hot6.web.spring.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CmdList {
    private String cmd1 = "시간순";
    private String cmd2 = "신고순";
    private String roomCnt;
}