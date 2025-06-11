package com.crypto.api.crypto.service.dao;

import com.crypto.api.crypto.service.entity.BalanceEntity;
import com.crypto.api.crypto.service.entity.CryptoPriceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface UserRepository {

    List<BalanceEntity> getWalletBalance(int userId);

    BigDecimal getBalance(int userId, String currencyCode);

    int deductBalance(int userId, String currencyCode, BigDecimal amount);

    void addAccountBalance(int userId, String currencyCode, BigDecimal amount);
}
