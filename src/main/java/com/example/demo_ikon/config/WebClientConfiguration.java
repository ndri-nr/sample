package com.example.demo_ikon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${app.data-gather.url}")
    private String dataGatherUrl;

    @Bean
    public WebClient dataGatherWebClient() {
        return WebClient.builder().baseUrl(dataGatherUrl).build();
    }

}
