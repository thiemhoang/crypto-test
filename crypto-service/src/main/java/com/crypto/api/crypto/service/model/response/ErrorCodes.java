

package com.crypto.api.crypto.service.model.response;

public enum ErrorCodes {
    INTERNAL_SERVER_ERROR("Server error, please contact admin for help");

    private final String message;

    private ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
