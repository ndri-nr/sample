package com.example.demo_ikon.service;

import com.example.demo_ikon.model.dto.PaginationDto;
import com.example.demo_ikon.model.response.DataGatherResponse;
import com.example.demo_ikon.model.response.PaginationResponse;

public interface DataGatherService {

    PaginationResponse<DataGatherResponse> getData(PaginationDto dto);

}
