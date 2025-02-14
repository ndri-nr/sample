package com.example.demo_ikon.controller;

import com.example.demo_ikon.model.dto.PaginationDto;
import com.example.demo_ikon.model.response.BaseResponse;
import com.example.demo_ikon.model.response.DataGatherResponse;
import com.example.demo_ikon.model.response.PaginationResponse;
import com.example.demo_ikon.service.DataGatherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/data")
public class DataGatheringController {

    private final DataGatherService dataGatherService;

    @PostMapping("")
    public BaseResponse<PaginationResponse<DataGatherResponse>> getData(
            @Valid @RequestBody PaginationDto dto
    ) {
        return BaseResponse.<PaginationResponse<DataGatherResponse>>builder()
                .message(HttpStatus.OK.name())
                .status(HttpStatus.OK.value())
                .data(dataGatherService.getData(dto))
                .build();
    }
}
