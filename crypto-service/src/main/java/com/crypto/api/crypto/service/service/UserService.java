package com.crypto.api.crypto.service.service;

import com.crypto.api.crypto.service.dao.UserRepository;
import com.crypto.api.crypto.service.entity.BalanceEntity;
import com.crypto.api.crypto.service.model.WalletBalanceModel;
import com.crypto.api.crypto.service.model.response.ListBalanceResponseModel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ListBalanceResponseModel getBalances(int userId) {
       List<BalanceEntity> entityList = userRepository.getWalletBalance(userId);

       if(CollectionUtils.isNotEmpty(entityList)) {
           return new ListBalanceResponseModel(
                   1,
                   entityList.size(),
                   false,
                   entityList.stream().map(WalletBalanceModel::new).collect(Collectors.toList())
           );
       }
       return new ListBalanceResponseModel();
    }
}
