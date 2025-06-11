package com.crypto.api.crypto.service.model;

import com.crypto.api.crypto.service.entity.BalanceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class WalletBalanceModel {
    private String currencyCode;
    private BigDecimal balance;

    public WalletBalanceModel(BalanceEntity entity) {
        this.currencyCode = entity.getCurrencyCode();
        this.balance = entity.getBalance();
    }
}
