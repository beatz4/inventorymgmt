package com.njh.project.inventorymgmt.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="TBL_COMPANY_MGMT")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long seq;

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Builder
    public Company(String name, String code, String phone, String email, Address address) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.createdDate = Instant.now();
        this.updatedDate = Instant.now();
    }

    public void changeCompanyData(String name, String code, String phone, String email) {
        this.name = name;
        this.code = code;
        this.phone = phone;
        this.email = email;
        this.updatedDate = Instant.now();
    }
}
