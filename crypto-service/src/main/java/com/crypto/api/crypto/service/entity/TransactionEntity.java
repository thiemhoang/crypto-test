package com.crypto.api.crypto.service.entity;

import com.crypto.api.crypto.service.model.request.TradingRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
public class TransactionEntity {

    private String symbol;
    private int userId;
    private BigDecimal amount;
    private BigDecimal price;
    private Timestamp transactionDateTime;
    private String transactionType;

    public TransactionEntity(BigDecimal price, int userId, TradingRequest request) {

        this.symbol = request.getSymbol();
        this.userId = userId;
        this.amount = request.getAmount();
        this.price = price;
        this.transactionType = request.getTradingType().toString();
        this.transactionDateTime = new Timestamp(new Date().getTime());

    }

}
