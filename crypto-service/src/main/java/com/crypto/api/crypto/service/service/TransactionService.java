package com.crypto.api.crypto.service.service;

import com.crypto.api.crypto.service.dao.TransactionRepository;
import com.crypto.api.crypto.service.entity.TransactionEntity;
import com.crypto.api.crypto.service.model.TransactionModel;
import com.crypto.api.crypto.service.model.request.TradingRequest;
import com.crypto.api.crypto.service.model.request.TransactionFilterRequest;
import com.crypto.api.crypto.service.model.response.ListTransactionHistoryResponseModel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public ListTransactionHistoryResponseModel search(TransactionFilterRequest request) {

        List<TransactionEntity> entities = transactionRepository.search(request);
        ListTransactionHistoryResponseModel responseModel = new ListTransactionHistoryResponseModel();

        if (CollectionUtils.isNotEmpty(entities)) {
            return new ListTransactionHistoryResponseModel(
                    request.getPage(),
                    request.getSize(),
                    entities.size() > request.getSize(),
                    entities.stream().map(TransactionModel::new).collect(Collectors.toList())
            );
        }

        return new ListTransactionHistoryResponseModel();

    }

    public void save(BigDecimal price, int userId, TradingRequest tradingRequest) {

        transactionRepository.insert(new TransactionEntity(price, userId, tradingRequest));
    }
}