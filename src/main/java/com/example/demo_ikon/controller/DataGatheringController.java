package com.example.demo_ikon.controller;

import com.example.demo_ikon.model.dto.PaginationDto;
import com.example.demo_ikon.model.response.DataGatherResponse;
import com.example.demo_ikon.model.response.PaginationResponse;
import com.example.demo_ikon.service.DataGatherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/data")
public class DataGatheringController {

    @Autowired
    private final DataGatherService dataGatherService;

    @GetMapping("/")
    public PaginationResponse<DataGatherResponse> getData(@RequestBody PaginationDto dto) {
        return dataGatherService.getData(dto);
    }
}
