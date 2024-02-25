package com.njh.project.inventorymgmt.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="TBL_PRODUCT_MGMT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long seq;

    @OneToMany(mappedBy = "productId")
    private List<Order> orders = new ArrayList<>();

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "price")
    private Long price;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Builder
    public Product(String name, String code, Long amount, Long price) {
        this.name = name;
        this.code = code;
        this.amount = amount;
        this.price = price;
        this.createdDate = Instant.now();
        this.updatedDate = Instant.now();
    }

    public void changeProductData(String name, String code, Long amount, Long price) {
        this.name = name;
        this.code = code;
        this.amount = amount;
        this.price = price;
        this.updatedDate = Instant.now();
    }
}
