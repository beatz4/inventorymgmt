package com.njh.project.inventorymgmt.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ProductDto {

    private Long seq;
    private String name;
    private String code;
    private Long amount;
    private Long price;
    private Instant createdDate;
    private Instant updatedDate;
}
