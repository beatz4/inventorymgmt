package com.njh.project.inventorymgmt.entity;

import java.time.Instant;

import com.njh.project.inventorymgmt.dto.AddressDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="TBL_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long seq;

    @Column(name = "zipcode")
    private Integer zipcode;

    @Column(name = "road_address")
    private String roadAddress;

    @Column(name = "jibun_address")
    private String jibunAddress;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "extra_address")
    private String extraAddress;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Builder
    public Address(Integer zipcode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress) {
        this.zipcode = zipcode;
        this.roadAddress = roadAddress;
        this.jibunAddress = jibunAddress;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
        this.createdDate = Instant.now();
    }

    public void changeAddressData(AddressDto addressDto) {
        this.zipcode = addressDto.getZipcode();
        this.roadAddress = addressDto.getRoadAddress();
        this.jibunAddress = addressDto.getJibunAddress();
        this.detailAddress = addressDto.getDetailAddress();
        this.extraAddress = addressDto.getExtraAddress();
        this.updatedDate = Instant.now();
    }
}
