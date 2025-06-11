package com.crypto.api.crypto.service.service;

import com.crypto.api.crypto.service.constant.AppConstant;
import com.crypto.api.crypto.service.dao.CryptoPriceRepository;
import com.crypto.api.crypto.service.dao.UserRepository;
import com.crypto.api.crypto.service.entity.CryptoPriceEntity;
import com.crypto.api.crypto.service.exception.handler.InsufficientBalanceException;
import com.crypto.api.crypto.service.model.request.TradingRequest;
import com.crypto.api.crypto.service.model.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TradingProcessingService {

    private final UserRepository userRepository;
    private final CryptoPriceRepository cryptoPriceRepository;
    private final TransactionService transactionService;

    @Transactional
    public ErrorResponse buy(TradingRequest tradingRequest) {

        CryptoPriceEntity price = cryptoPriceRepository.getPrice(tradingRequest.getSymbol());
        BigDecimal costAmount = tradingRequest.getAmount().divide(price.getAskPrice());
        BigDecimal availableBalance = userRepository.getBalance(AppConstant.USER_ID, AppConstant.MAIN_CURRENCY_CODE);
        if(availableBalance.compareTo(costAmount) >= 0) {
            int affectedRow = userRepository.deductBalance(AppConstant.USER_ID, AppConstant.MAIN_CURRENCY_CODE , costAmount);
            if(affectedRow > 0) {
                // create transaction
                transactionService.save(price.getAskPrice(), AppConstant.USER_ID, tradingRequest);
                userRepository.addAccountBalance(AppConstant.USER_ID, tradingRequest.getSymbol(), tradingRequest.getAmount());
            } else {
                throw new InsufficientBalanceException("InsufficientBalance");
            }
        }
        throw new InsufficientBalanceException("InsufficientBalance");

    }

    @Transactional
    public ErrorResponse sell(TradingRequest tradingRequest) {

        BigDecimal requestAmount = tradingRequest.getAmount();
        BigDecimal availableBalance = userRepository.getBalance(AppConstant.USER_ID, tradingRequest.getSymbol());
        if(availableBalance.compareTo(requestAmount) >= 0) {
            int affectedRow = userRepository.deductBalance(AppConstant.USER_ID, tradingRequest.getSymbol(), requestAmount);
            if(affectedRow > 0) {
                // create transaction
                CryptoPriceEntity price = cryptoPriceRepository.getPrice(tradingRequest.getSymbol());
                BigDecimal convertedAmount = tradingRequest.getAmount().divide(price.getBidPrice());
                transactionService.save(price.getBidPrice(), AppConstant.USER_ID, tradingRequest);
                userRepository.addAccountBalance(AppConstant.USER_ID, AppConstant.MAIN_CURRENCY_CODE, convertedAmount);
            } else {
                throw new InsufficientBalanceException("InsufficientBalance");
            }
        }
        throw new InsufficientBalanceException("InsufficientBalance");

    }
}
