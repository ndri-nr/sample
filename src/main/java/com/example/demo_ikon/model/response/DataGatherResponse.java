package com.example.demo_ikon.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataGatherResponse {

    private Integer id;
    private String title;

    @JsonIgnore
    private String userId;

    @JsonIgnore
    private String body;

}
