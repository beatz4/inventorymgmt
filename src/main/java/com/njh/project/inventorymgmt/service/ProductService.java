package com.njh.project.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njh.project.inventorymgmt.dto.ProductDto;
import com.njh.project.inventorymgmt.entity.Product;
import com.njh.project.inventorymgmt.exception.NotFoundException;
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

    public Boolean save(Long seq, String name, String code, Long amount, Long price) {

        try {
            if (seq > 0) {

                Optional<Product> product = productRepository.findById(seq);

                if (product.isPresent()) {

                    product.get().changeProductData(name, code, amount, price);
                    productRepository.save(product.get());
                } else {
                    log.error("Not found exception in save function...");
                    throw new NotFoundException("상품을 찾지 못했습니다.");
                }

            } else {
                productRepository.save(Product.builder()
                    .name(name)
                    .code(code)
                    .amount(amount)
                    .price(price)
                .build());
            }
        } catch (Exception e) {
            log.error("Occured something wrong...");
            return false;
        }

        return true;
    }
}
