package com.crypto.scheduler.external.http;

import com.crypto.scheduler.config.ExternalSetting;
import com.crypto.scheduler.external.BinancePrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CryptoPriceApiService {

    private final RestClient restClient;
    private final ExternalSetting externalSetting;

    public List<BinancePrice> getPrices() {
        StopWatch watch = new StopWatch();
        watch.start("Get Prices");
        try {
            return restClient.get().uri(uriBuilder -> uriBuilder
                            .scheme(externalSetting.getScheme())
                            .host(externalSetting.getHost())
                            .path(externalSetting.getPath())
                            .queryParamIfPresent("symbols", Optional.ofNullable(externalSetting.getSybolsParam()).filter(StringUtils::hasText))
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve().body(new ParameterizedTypeReference<List<BinancePrice>>() {
                    });
        } finally {
            watch.stop();
            log.info(watch.prettyPrint());
        }
    }
}
