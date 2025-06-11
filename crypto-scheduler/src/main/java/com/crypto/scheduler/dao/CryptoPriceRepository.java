package com.crypto.scheduler.dao;


import com.crypto.scheduler.entity.CryptoPriceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CryptoPriceRepository {

    void saveAll(List<CryptoPriceEntity> entities);

}