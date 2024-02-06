package com.njh.project.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njh.project.inventorymgmt.dto.ProductDto;
import com.njh.project.inventorymgmt.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProductService {
    
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getList() {

        return productRepository.findAll().stream().map(x -> 
            ProductDto.builder()
                .seq(x.getSeq())
                .name(x.getName())
                .code(x.getCode())
                .amount(x.getAmount())
                .price(x.getPrice())
                .createdDate(x.getCreatedDate())
                .updatedDate(x.getUpdatedDate())
            .build()).collect(Collectors.toList());
    }
}
