package com.crypto.api.crypto.service.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
