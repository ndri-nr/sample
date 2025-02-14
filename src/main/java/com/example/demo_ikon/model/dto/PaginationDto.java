package com.example.demo_ikon.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationDto implements Serializable {
	@Serial
	private static final long serialVersionUID = -660387899922175712L;

	@NotNull(message = "page is mandatory")
	@Min(value = 1, message = "page must be greater than or equal to 1")
	private Integer page;

	@NotNull(message = "size is mandatory")
	@Min(value = 1, message = "size must be greater than or equal to 1")
	private Integer size;
}
