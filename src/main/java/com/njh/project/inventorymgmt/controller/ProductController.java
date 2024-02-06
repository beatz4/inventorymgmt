package com.njh.project.inventorymgmt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.njh.project.inventorymgmt.dto.ProductDto;
import com.njh.project.inventorymgmt.service.ProductService;

@Controller
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/productmgmt")
    public String getInventoryView() {
        return "/productmgmt";
    }
    
    @GetMapping("/productmgmt/list")
    public List<ProductDto> getList() {
        return productService.getList();
    }
    
}
