package com.crypto.scheduler.task;


import com.crypto.scheduler.service.CryptoPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class CryptoPriceScheduler {

    private final CryptoPriceService cryptoPriceService;

    @Scheduled(fixedDelay = 10000, initialDelay = 1000)
    public void syncCryptoPrices() {
        try {
                cryptoPriceService.syncPrice();
        } catch (Throwable e) {
            log.error("error in task syncCryptoPrices:", e);
        }
    }

}
