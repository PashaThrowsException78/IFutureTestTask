package com.tabakov.ifuture.crosscut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {

    private int getAmountCallsPerHour = 0;
    private int addAmountCallsPerHour = 0;
    private int getAmountCallsTotal = 0;
    private int addAmountCallsTotal = 0;

    public void noticeGetAmountCall() {
        getAmountCallsPerHour++;
        getAmountCallsTotal++;
    }

    public void noticeAddAmountCall() {
        addAmountCallsPerHour++;
        addAmountCallsTotal++;
    }

    public void refreshHourStatistic() {
        getAmountCallsPerHour = 0;
        addAmountCallsPerHour = 0;
    }
}
