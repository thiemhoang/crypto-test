package com.crypto.api.crypto.service.dao;

import com.crypto.api.crypto.service.entity.TransactionEntity;
import com.crypto.api.crypto.service.model.request.TransactionFilterRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransactionRepository {
    List<TransactionEntity> search(@Param("request") TransactionFilterRequest request);

    void insert(@Param("entity")TransactionEntity transactionEntity);
}
