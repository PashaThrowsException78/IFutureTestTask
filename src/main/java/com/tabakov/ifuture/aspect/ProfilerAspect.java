package com.tabakov.ifuture.aspect;

import com.tabakov.ifuture.service.statistic.StatisticService;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilerAspect {

    @Autowired
    private StatisticService statisticService;

    @Pointcut(value = "execution(public * com.tabakov.ifuture.controller.AccountController.addAmount(*))")
    public void onAddAmount() {}

    @Pointcut(value = "execution(public * com.tabakov.ifuture.controller.AccountController.getAmount(*))")
    public void onGetAmount() {}


    @Before(value = "onAddAmount()")
    public void noticeAddAmountCall() {
        System.out.println("noticed add");
        statisticService.noticeAddAmountCall();
    }

    @Before(value = "onGetAmount()")
    public void noticeGetAmountCall() {
        System.out.println("noticed get");

        statisticService.noticeGetAmountCall();
    }

}
