package com.hot6.web.spring.controller;

import com.hot6.web.spring.domain.vo.RankingDTO;
import com.hot6.web.spring.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/rank/*")
public class RankingController {
    private final RankingService rankingService;

    // 랭킹 페이지 이동
    @GetMapping("/ranking")
    public void ranking(Model model) {
        List<RankingDTO> rankingDTOS = rankingService.showAll();
        for (RankingDTO rankingDTO : rankingDTOS) {
            rankingDTO.calculateCorrectPercent();
        }
        model.addAttribute("rankings", rankingDTOS);
    }

    @GetMapping("/rankingBy")
    @ResponseBody
    public List<RankingDTO> rankingBy(@RequestParam String userGrade) {
        List<RankingDTO> rankingDTOS = rankingService.showAllBy(userGrade);
        for (RankingDTO rankingDTO : rankingDTOS) {
            rankingDTO.calculateCorrectPercent();
        }
        return rankingDTOS;
    }

    @GetMapping("/rankingAll")
    @ResponseBody
    public List<RankingDTO> rankingBy() {
        List<RankingDTO> rankingDTOS = rankingService.showAll();
        for (RankingDTO rankingDTO : rankingDTOS) {
            rankingDTO.calculateCorrectPercent();
        }
        return rankingDTOS;
    }




}
