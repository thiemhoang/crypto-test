package com.crypto.api.crypto.service.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceEntity {
    private String currencyCode;
    private BigDecimal balance;
}
