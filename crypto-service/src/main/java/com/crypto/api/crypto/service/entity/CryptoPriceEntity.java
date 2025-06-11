package com.crypto.api.crypto.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CryptoPriceEntity {

    private String symbol;
    private BigDecimal bidPrice;
    private BigDecimal  askPrice;

}
