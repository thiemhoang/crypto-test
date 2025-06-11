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
    private String symbol;
    private BigDecimal balance;

    public WalletBalanceModel(BalanceEntity entity) {
        this.symbol = entity.getSymbol();
        this.balance = entity.getBalance();
    }
}
