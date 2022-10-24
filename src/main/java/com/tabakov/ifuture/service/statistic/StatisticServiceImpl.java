package com.tabakov.ifuture.service.statistic;

import com.tabakov.ifuture.crosscut.Statistic;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final Statistic statistic;

    public StatisticServiceImpl() {
        this.statistic = new Statistic();
    }

    @Override
    public void noticeGetAmountCall() {
        statistic.noticeGetAmountCall();
    }

    @Override
    public void noticeAddAmountCall() {
        statistic.noticeAddAmountCall();
    }

    @Override
    public void refreshHourStatistic() {
        statistic.refreshHourStatistic();
    }

    @Override
    public Statistic getStatistic() {
        return new Statistic(statistic.getGetAmountCallsPerHour(), statistic.getAddAmountCallsPerHour(),
                statistic.getGetAmountCallsTotal(), statistic.getAddAmountCallsTotal());
    }

}
