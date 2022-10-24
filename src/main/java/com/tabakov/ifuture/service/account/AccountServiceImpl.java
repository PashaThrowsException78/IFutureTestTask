package com.tabakov.ifuture.service.account;

import com.tabakov.ifuture.domain.Account;
import com.tabakov.ifuture.repo.AccountRepo;
import com.tabakov.ifuture.exception.AccountNotFoundException;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mapping.AccessOptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
@CacheConfig(cacheNames = "amount")
public class AccountServiceImpl implements AccountService {

    private final ApplicationContext applicationContext;

    private final AccountRepo accountRepo;

    private AccountServiceImpl self; // self-injection to invoke getAmount method through Spring proxy (cache and transaction)

    public AccountServiceImpl(AccountRepo accountRepo, ApplicationContext applicationContext) {
        this.accountRepo = accountRepo;
        this.applicationContext = applicationContext;
    }


    @Cacheable(key="#id")
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long getAmount(Integer id) {
        Account account = accountRepo.findAccountById(id);
        if (account == null) {
            throw new AccountNotFoundException(id);
        }

        return account.getAmount();
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(propagation = REQUIRED)
    public void addAmount(Integer id, Long value) {
        Long oldAmount;
        try {
            oldAmount = self.getAmount(id);
        } catch (AccountNotFoundException e) {
            oldAmount = 0L;
        }

        Account account = new Account(id, oldAmount + value);

        accountRepo.save(account);
    }


    @PostConstruct
    private void init() {
        self = applicationContext.getBean(AccountServiceImpl.class);
    }
}
