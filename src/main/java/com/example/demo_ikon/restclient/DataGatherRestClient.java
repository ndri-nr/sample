package com.example.demo_ikon.restclient;

import com.example.demo_ikon.model.response.DataGatherResponse;
import com.example.demo_ikon.model.response.DataGatherResponseList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class DataGatherRestClient {

    private final WebClient dataGatherWebClient;

    public DataGatherResponseList getData() {
        ObjectMapper objectMapper = new ObjectMapper();
        String responseString = dataGatherWebClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToMono(String.class).block();

        try {
            return DataGatherResponseList.builder()
                    .items(objectMapper.readValue(responseString, new TypeReference<List<DataGatherResponse>>(){}))
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
