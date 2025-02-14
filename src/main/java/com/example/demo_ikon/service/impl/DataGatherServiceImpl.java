package com.example.demo_ikon.service.impl;

import com.example.demo_ikon.exception.BadRequestException;
import com.example.demo_ikon.model.dto.PaginationDto;
import com.example.demo_ikon.model.response.DataGatherResponse;
import com.example.demo_ikon.model.response.DataGatherResponseList;
import com.example.demo_ikon.model.response.PaginationResponse;
import com.example.demo_ikon.restclient.DataGatherRestClient;
import com.example.demo_ikon.service.DataGatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataGatherServiceImpl implements DataGatherService {

    private final DataGatherRestClient dataGatherRestClient;

    @Override
    public PaginationResponse<DataGatherResponse> getData(PaginationDto dto) {
        DataGatherResponseList list = dataGatherRestClient.getData();
        int startIndex = getStartIndex(dto);
        int lastIndex = getLastIndex(dto, list.getItems().size());

        if (startIndex > list.getItems().size()) {
            throw new BadRequestException("Page size invalid value");
        }

        List<DataGatherResponse> filtered = new ArrayList<>();

        for (int i = startIndex; i < lastIndex; i++) {
            filtered.add(list.getItems().get(i));
        }

        int totalPages = list.getItems().size() / dto.getSize();
        if (list.getItems().size() % dto.getSize() > 0) {
            totalPages++;
        }

        return PaginationResponse.<DataGatherResponse>builder()
                .totalData(list.getItems().size())
                .currentPage(dto.getPage())
                .totalPages(totalPages)
                .pageSize(filtered.size())
                .contents(filtered)
                .firstPage(dto.getPage() == 1)
                .lastPage(dto.getPage() == totalPages)
                .build();
    }

    public int getStartIndex(PaginationDto dto) {
        return (dto.getPage() - 1) * dto.getSize();
    }

    public int getLastIndex(PaginationDto dto, Integer totalList) {
        int lastIndex = ((dto.getPage() - 1) * dto.getSize()) + dto.getSize();
        if (lastIndex > totalList) {
            lastIndex = totalList;
        }
        return lastIndex;
    }

}
