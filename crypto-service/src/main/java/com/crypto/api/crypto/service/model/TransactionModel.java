package com.crypto.api.crypto.service.model;

import com.crypto.api.crypto.service.entity.TransactionEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data

public class TransactionModel {

    private String symbol;
    private int userId;
    private BigDecimal amount;
    private BigDecimal price;
    private LocalDateTime transactionDateTime;
    private String transactionType;

    public TransactionModel(TransactionEntity entity) {

        this.symbol = entity.getSymbol();
        this.userId = entity.getUserId();
        this.amount = entity.getAmount();
        this.price = entity.getPrice();
        Instant instant = Instant.ofEpochMilli(entity.getTransactionDateTime().getTime());
        this.transactionDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        this.transactionType = entity.getTransactionType();
    }
}
