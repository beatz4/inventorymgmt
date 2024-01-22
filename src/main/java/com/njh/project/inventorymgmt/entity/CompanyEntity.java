package com.njh.project.inventorymgmt.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_COMPANY_MGMT")
public class CompanyEntity {
    
    @Id
    @Column(name = "id")
    private Long seq;

    @Column(name = "code")
    private String code;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "created_date")
    private Instant createdDate;
}
