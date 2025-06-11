package com.crypto.api.crypto.service.service;

import com.crypto.api.crypto.service.dao.TradingRepository;
import com.crypto.api.crypto.service.entity.CryptoPriceEntity;
import com.crypto.api.crypto.service.model.CryptoLatestPriceModel;
import com.crypto.api.crypto.service.model.request.TradingRequest;
import com.crypto.api.crypto.service.model.response.ErrorResponse;
import com.crypto.api.crypto.service.model.response.ListCryptoResponseModel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TradingService {

    private final TradingRepository tradingRepository;

    private final TradingProcessingService tradingProcessingService;
    public ListCryptoResponseModel getLatestPrice() {

        List<CryptoPriceEntity> entities = tradingRepository.getLatestPrice();
        if(CollectionUtils.isNotEmpty(entities)) {
            return new ListCryptoResponseModel(1,
                    entities.size(),
                    false,
                    entities.stream().map(CryptoLatestPriceModel::new).collect(Collectors.toList())
            );
        }

        return new ListCryptoResponseModel();


    }

    public ErrorResponse buy(TradingRequest tradingRequest) {
        return tradingProcessingService.buy(tradingRequest);
    }

    public ErrorResponse sell(TradingRequest tradingRequest) {
        return tradingProcessingService.sell(tradingRequest);
    }
}