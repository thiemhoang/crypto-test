package com.crypto.api.crypto.service.dao;

import com.crypto.api.crypto.service.entity.CryptoPriceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CryptoPriceRepository {

    CryptoPriceEntity getPrice(String symbol);
}
