package com.njh.project.inventorymgmt.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CompanyDto {

    private Long seq;
    private String code;
    private String address;
    private String phone;
    private String email;
    private Instant createdDate;
}
