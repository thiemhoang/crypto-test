package com.crypto.api.crypto.service.model.response;

import com.crypto.api.crypto.service.model.CryptoLatestPriceModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListCryptoResponseModel extends PaginationResponseModel {
    private List<CryptoLatestPriceModel> data;

    public ListCryptoResponseModel(int page, int size, boolean isMoreAvailable, List<CryptoLatestPriceModel> data) {
        super(page, size, isMoreAvailable);
        this.data = (data);
    }
}
