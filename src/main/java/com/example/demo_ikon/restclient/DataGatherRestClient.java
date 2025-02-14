package com.example.demo_ikon.restclient;

import com.example.demo_ikon.model.response.DataGatherResponseList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class DataGatherRestClient {

    private final WebClient dataGatherWebClient;

    public DataGatherResponseList getData() {
        return dataGatherWebClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToMono(DataGatherResponseList.class).block();
    }

}
