package com.tabakov.ifuture.service.account;

import com.tabakov.ifuture.exception.AccountNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceMock implements AccountService {
    private final Map<Integer, Long> accountMap;

    public AccountServiceMock() {
        this.accountMap = new HashMap<>();
    }

    @Override
    public Long getAmount(Integer id) {
        if (accountMap.containsKey(id))
            return accountMap.get(id);
        throw new AccountNotFoundException(id);
    }

    @Override
    public void addAmount(Integer id, Long value) {
        if (accountMap.containsKey(id)) {
            accountMap.replace(id, accountMap.get(id) + value);
        } else {
            accountMap.put(id, value);
        }
    }
}
