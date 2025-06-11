package com.crypto.api.crypto.service.dao;

import com.crypto.api.crypto.service.entity.TransactionEntity;
import com.crypto.api.crypto.service.model.request.TransactionFilterRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransactionRepository {
    List<TransactionEntity> search(TransactionFilterRequest request);

    void insert(TransactionEntity transactionEntity);
}
