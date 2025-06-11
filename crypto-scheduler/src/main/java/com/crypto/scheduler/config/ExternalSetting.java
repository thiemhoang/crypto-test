package com.crypto.scheduler.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "crypto.external")
@Getter
@Setter
@Component
public class ExternalSetting {

    private String host;

    private String scheme;

    private String path;

    private String sybolsParam;

}
