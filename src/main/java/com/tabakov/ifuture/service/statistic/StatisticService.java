package com.tabakov.ifuture.service.statistic;

import com.tabakov.ifuture.crosscut.Statistic;

public interface StatisticService {
    void noticeAddAmountCall();
    void noticeGetAmountCall();
    void refreshHourStatistic();
    Statistic getStatistic();
}
