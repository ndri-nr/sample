package com.example.demo_ikon.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationResponse<T> implements Serializable {

	@Serial
	private static final long serialVersionUID = -891823812177125351L;

	private List<T> contents;
	private boolean firstPage;
	private boolean lastPage;
	private long totalPages;
	private long totalData;
	private long currentPage;
	private long pageSize;
}
