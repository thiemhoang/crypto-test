package com.crypto.scheduler.service.impl;

import com.crypto.scheduler.dao.CryptoPriceRepository;
import com.crypto.scheduler.entity.CryptoPriceEntity;
import com.crypto.scheduler.external.BinancePrice;
import com.crypto.scheduler.external.http.CryptoPriceApiService;
import com.crypto.scheduler.service.CryptoPriceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CryptoPriceServiceImpl implements CryptoPriceService {

    private final CryptoPriceApiService cryptoPriceApiService;
    private final CryptoPriceRepository cryptoPriceRepository;


    @Override
    public void syncPrice() {
        List<BinancePrice> prices = cryptoPriceApiService.getPrices();
        if (CollectionUtils.isNotEmpty(prices)) {
            ListUtils.partition(prices, 50).stream().forEach(chunk -> {
                try {
                    cryptoPriceRepository.saveAll(chunk.stream().map(CryptoPriceEntity::new).collect(Collectors.toUnmodifiableList()));
                } catch (Throwable e) {
                    log.error("Cannot save crypto prices", e);
                }
            });
        }
    }

}
