package com.crypto.api.crypto.service.controller;

import com.crypto.api.crypto.service.constant.AppConstant;
import com.crypto.api.crypto.service.model.request.TransactionFilterRequest;
import com.crypto.api.crypto.service.model.response.ListTransactionHistoryResponseModel;
import com.crypto.api.crypto.service.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping({"/transaction"})
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping({"/v1/history"})
    public ResponseEntity<ListTransactionHistoryResponseModel> searchTransaction(@RequestParam(required = false) String transactionType, @RequestParam(required = false) LocalDate transactionDate, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(defaultValue = "50", required = false) int size) {
        TransactionFilterRequest searchRequest = new TransactionFilterRequest(AppConstant.USER_ID, transactionType, transactionDate, page, size);
        return ResponseEntity.ok(this.transactionService.search(searchRequest));
    }
}