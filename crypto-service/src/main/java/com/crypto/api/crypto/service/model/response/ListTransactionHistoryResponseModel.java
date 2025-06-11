package com.crypto.api.crypto.service.model.response;

import com.crypto.api.crypto.service.model.TransactionModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListTransactionHistoryResponseModel extends PaginationResponseModel {
    private List<TransactionModel> transactions;

    public ListTransactionHistoryResponseModel(int page, int size, boolean isMoreAvailable, List<TransactionModel> transactions) {
        super(page, size, isMoreAvailable);
        this.transactions = transactions;
    }
}
