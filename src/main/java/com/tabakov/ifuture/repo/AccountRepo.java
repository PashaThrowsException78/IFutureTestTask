package com.tabakov.ifuture.repo;

import com.tabakov.ifuture.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Integer> {
    Account findAccountById(Integer id);

}
