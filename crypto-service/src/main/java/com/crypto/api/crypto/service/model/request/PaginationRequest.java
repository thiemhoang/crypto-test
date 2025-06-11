package com.crypto.api.crypto.service.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PaginationRequest {
    private int page;
    private int size;

    public PaginationRequest(final int page, final int size) {
        this.page = page;
        this.size = size;
    }

    public int getOffset() {
        return page * size;
    }
}
