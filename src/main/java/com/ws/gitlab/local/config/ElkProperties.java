package com.ws.gitlab.local.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "elk-stack")
public class ElkProperties {

    private String host;
    private int port;
}
