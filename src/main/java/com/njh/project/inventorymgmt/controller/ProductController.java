package com.njh.project.inventorymgmt.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njh.project.inventorymgmt.dto.AddressDto;
import com.njh.project.inventorymgmt.dto.ProductDto;
import com.njh.project.inventorymgmt.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/productmgmt/list")
    public List<ProductDto> getList() {
        return productService.getList();
    }
    
    @PostMapping("/productmgmt/save")
    public Boolean save(HttpServletRequest request) {
        
        JSONObject jsonObject = new JSONObject(request.getParameter("items"));

        Long seq = -1L;
        if (jsonObject.has("seq") && !jsonObject.get("seq").toString().isEmpty()) {
            seq = Long.parseLong(jsonObject.get("seq").toString());
        }
        String name = jsonObject.get("name").toString();
        String code = jsonObject.get("code").toString();
        Long amount = Long.parseLong(jsonObject.get("amount").toString());
        Long price = Long.parseLong(jsonObject.get("price").toString());

        try {
            productService.save(seq, name, code, amount, price);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }
    
}
