package com.hot6.web.spring.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class CriteriaDTO {
    private int page;
    private int amount;

    private Long userNumber;

    public CriteriaDTO create(int page, int amount) {
        this.page = page;
        this.amount = amount;
        return this;
    }

    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount);
        return builder.toUriString();
    }
}