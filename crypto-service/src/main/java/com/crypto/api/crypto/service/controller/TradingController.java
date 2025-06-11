package com.crypto.api.crypto.service.controller;

import com.crypto.api.crypto.service.constant.TradingType;
import com.crypto.api.crypto.service.model.request.TradingRequest;
import com.crypto.api.crypto.service.model.response.ErrorResponse;
import com.crypto.api.crypto.service.model.response.ListCryptoResponseModel;
import com.crypto.api.crypto.service.service.TradingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/trading"})
@AllArgsConstructor
public class TradingController {

    private final TradingService tradingService;

    @GetMapping({"/v1/latest-price"})
    public ResponseEntity<ListCryptoResponseModel> getLatestPrice() {
        return ResponseEntity.ok(this.tradingService.getLatestPrice());
    }

    @PostMapping({"/v1/buy"})
    public ResponseEntity<ErrorResponse> buy(@RequestBody TradingRequest tradingRequest)  {

        tradingRequest.setTradingType(TradingType.BUY);
        return ResponseEntity.ok(this.tradingService.buy(tradingRequest));
    }

    @PostMapping({"/v1/sell"})
    public ResponseEntity<ErrorResponse> sell(@RequestBody TradingRequest tradingRequest) {
        tradingRequest.setTradingType(TradingType.SELL);
        return ResponseEntity.ok(this.tradingService.sell(tradingRequest));
    }


}
