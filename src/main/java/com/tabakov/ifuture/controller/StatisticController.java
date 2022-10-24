package com.tabakov.ifuture.controller;

import com.tabakov.ifuture.service.statistic.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/total")
    public ResponseEntity<?> getStatistic() {

        return new ResponseEntity<>(statisticService.getStatistic(), HttpStatus.OK);
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> refresh() {
       // statisticService.refresh();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
