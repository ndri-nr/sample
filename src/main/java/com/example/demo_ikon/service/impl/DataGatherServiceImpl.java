package com.example.demo_ikon.service.impl;

import com.example.demo_ikon.model.dto.PaginationDto;
import com.example.demo_ikon.model.response.DataGatherResponse;
import com.example.demo_ikon.model.response.DataGatherResponseList;
import com.example.demo_ikon.model.response.PaginationResponse;
import com.example.demo_ikon.restclient.DataGatherRestClient;
import com.example.demo_ikon.service.DataGatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DataGatherServiceImpl implements DataGatherService {

    private final DataGatherRestClient dataGatherRestClient;

    @Override
    public PaginationResponse<DataGatherResponse> getData(PaginationDto dto) {
        DataGatherResponseList list = dataGatherRestClient.getData();

        return PaginationResponse.<DataGatherResponse>builder()
                .totalData(list.getItems().size())
                .currentPage(dto.getPage())
                .pageSize(list.getItems().size() / dto.getSize())
                .contents(list.getItems())
                .build();
    }

}
