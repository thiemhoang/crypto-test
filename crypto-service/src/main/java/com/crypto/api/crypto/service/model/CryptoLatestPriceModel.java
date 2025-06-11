package com.crypto.api.crypto.service.model;

import com.crypto.api.crypto.service.entity.CryptoPriceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CryptoLatestPriceModel {
    private String symbol;
    private BigDecimal bidPrice;
    private BigDecimal askPrice;

    public CryptoLatestPriceModel(CryptoPriceEntity entity) {
        this.symbol = entity.getSymbol();
        this.bidPrice = entity.getBidPrice();
        this.askPrice = entity.getAskPrice();
    }
}
