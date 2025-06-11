

package com.crypto.api.crypto.service.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransactionFilterRequest extends PaginationRequest {
    private int userId;
    private String transactionType;
    private LocalDate transactionDate;

    public TransactionFilterRequest(int userId, String transactionType, LocalDate transactionDate, int page, int size) {
        super(page, size);
        this.userId = userId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }
}
