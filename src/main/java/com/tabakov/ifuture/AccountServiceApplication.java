package com.tabakov.ifuture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class AccountServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

}
