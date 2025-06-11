package com.crypto.api.crypto.service.model.request;

import com.crypto.api.crypto.service.constant.TradingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TradingRequest {
    private TradingType tradingType;
    private BigDecimal amount;
    private String symbol;

}
