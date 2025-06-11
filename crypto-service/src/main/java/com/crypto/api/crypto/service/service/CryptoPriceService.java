package com.crypto.api.crypto.service.service;

import com.crypto.api.crypto.service.dao.CryptoPriceRepository;
import com.crypto.api.crypto.service.entity.CryptoPriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CryptoPriceService {

     private final CryptoPriceRepository cryptoPriceRepository;


     public BigDecimal exchangeAsk(String symbol, BigDecimal amount) {

          CryptoPriceEntity price = cryptoPriceRepository.getPrice(symbol);
          return amount.divide(price.getAskPrice());

     }

     public BigDecimal exchangeBid(String symbol, BigDecimal amount) {
          CryptoPriceEntity price = cryptoPriceRepository.getPrice(symbol);
          return amount.divide(price.getBidPrice());
     }
}
