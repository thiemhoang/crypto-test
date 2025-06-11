package com.crypto.api.crypto.service.model.response;

import com.crypto.api.crypto.service.model.WalletBalanceModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListBalanceResponseModel extends PaginationResponseModel {
    private List<WalletBalanceModel> wallet;

    public ListBalanceResponseModel(int page, int size, boolean isMoreAvailable, List<WalletBalanceModel> wallet) {
        super(page, size, isMoreAvailable);
        this.wallet = (wallet);
    }
}
