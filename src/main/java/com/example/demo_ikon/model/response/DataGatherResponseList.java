package com.example.demo_ikon.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class DataGatherResponseList {

    private List<DataGatherResponse> items;

}
