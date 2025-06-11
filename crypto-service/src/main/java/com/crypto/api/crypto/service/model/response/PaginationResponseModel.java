

package com.crypto.api.crypto.service.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaginationResponseModel {
    private int page;
    private int size;
    private boolean isMoreAvailable;

    public PaginationResponseModel(final int page, final int size, final boolean isMoreAvailable) {
        this.page = page;
        this.size = size;
        this.isMoreAvailable = isMoreAvailable;
    }
}
