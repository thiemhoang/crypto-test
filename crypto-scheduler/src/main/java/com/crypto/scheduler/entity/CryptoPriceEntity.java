package com.crypto.scheduler.entity;

import com.crypto.scheduler.external.BinancePrice;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CryptoPriceEntity {

    private String symbol;
    private BigDecimal bidPrice;
    private BigDecimal  askPrice;

    public CryptoPriceEntity(BinancePrice binancePrice) {
        this.symbol = binancePrice.getSymbol();
        this.bidPrice= binancePrice.getBidPrice();
        this.askPrice= binancePrice.getAskPrice();
    }

}
