package com.njh.project.inventorymgmt.dto;

import java.time.Instant;

import com.njh.project.inventorymgmt.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class AddressDto {

    // private Long seq;
    private Integer zipcode;
    private String roadAddress;
    private String jibunAddress;
    private String detailAddress;
    private String extraAddress;
    private Instant createdDate;
    private Instant updatedDate;

    public static Address toEntity(AddressDto dto) {
        return Address.builder()
                .zipcode(dto.getZipcode())
                .roadAddress(dto.getRoadAddress())
                .jibunAddress(dto.getJibunAddress())
                .detailAddress(dto.getDetailAddress())
                .extraAddress(dto.getExtraAddress())
            .build();
    }
}
