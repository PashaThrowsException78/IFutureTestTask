package com.tabakov.ifuture.config;

import com.tabakov.ifuture.service.statistic.StatisticService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {

    private final StatisticService statisticService;

    public SchedulerConfig(StatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @Scheduled(cron="0 * * * * *", zone = "GMT+3")
    public void refreshHourStatistic() {
        statisticService.refreshHourStatistic();
    }
}
