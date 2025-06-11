package com.crypto.api.crypto.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceEntity {
    private String symbol;
    private BigDecimal balance;
}
