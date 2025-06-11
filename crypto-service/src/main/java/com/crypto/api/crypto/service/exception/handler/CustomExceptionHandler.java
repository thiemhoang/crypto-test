package com.crypto.api.crypto.service.exception.handler;

import com.crypto.api.crypto.service.model.response.ErrorCodes;
import com.crypto.api.crypto.service.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger LOGGER = Logger.getLogger(CustomExceptionHandler.class.getName());

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleInternalException(Exception ex) {
        this.LOGGER.log(Level.SEVERE, "handleInternalException > ", ex);
        ErrorResponse responseBody = new ErrorResponse(ErrorCodes.INTERNAL_SERVER_ERROR.name(), ErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
        return ResponseEntity.internalServerError().body(responseBody);
    }
}