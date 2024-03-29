package com.njh.project.inventorymgmt.dto;

import java.time.Instant;

import com.njh.project.inventorymgmt.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CompanyDto {

    private Long seq;
    private String name;
    private String code;
    private Address address;
    private String phone;
    private String email;
    private Instant createdDate;
    private Instant updatedDate;
}
