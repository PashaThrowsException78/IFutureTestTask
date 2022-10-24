package com.tabakov.ifuture.domain;

import javax.persistence.*;

@Entity
public class Account {
    public Account() {

    }

    public Account(Integer id, Long amount) {
        this.id = id;
        this.amount = amount;
    }

    @Id
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Long amount = 0L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
