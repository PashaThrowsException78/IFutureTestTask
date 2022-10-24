package com.tabakov.ifuture.util;

import com.tabakov.ifuture.dto.AccountDTO;

public class AccountValidator {
    public static boolean isValid(AccountDTO accountDTO) {
        return accountDTO.getId() != null && accountDTO.getId() > 0
                && accountDTO.getAmount() != null;
    }
}
