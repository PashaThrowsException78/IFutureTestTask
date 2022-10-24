package com.tabakov.ifuture.controller;

import com.tabakov.ifuture.dto.AccountDTO;
import com.tabakov.ifuture.exception.AccountNotFoundException;
import com.tabakov.ifuture.exception.layer.BusinessLayerException;
import com.tabakov.ifuture.service.account.AccountService;
import com.tabakov.ifuture.util.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AccountController {

    private final AccountService accountService;

    public AccountController(@Qualifier("accountServiceImpl") AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<?> getAmount(@RequestParam int id) {
        try {
            Long amount = accountService.getAmount(id);
            return new ResponseEntity<>(amount, HttpStatus.OK);
        } catch (AccountNotFoundException e) {
            log.info("getAmount request with id=" + id + ": account with specified id not found");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (BusinessLayerException e) {
            log.info("getAmount request id=" + id + ": exception from business layer");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    /*
        Due to test task definition, service has single method for create and update both,
        So then it will be OK if I make single method for controller too.
    */
    public ResponseEntity<?> addAmount(@RequestBody AccountDTO account) {
        if(!AccountValidator.isValid(account)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        accountService.addAmount(account.getId(), account.getAmount());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
