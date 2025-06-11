package com.crypto.api.crypto.service.dao;

import com.crypto.api.crypto.service.entity.BalanceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface UserRepository {

    List<BalanceEntity> getWalletBalance(@Param("userId") int userId);

    BigDecimal getBalance(int userId, String symbol);

    int deductBalance(int userId, String symbol, BigDecimal amount);

    void addAccountBalance(int userId, String symbol, BigDecimal amount);
}
