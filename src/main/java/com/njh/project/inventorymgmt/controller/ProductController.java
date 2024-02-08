package com.njh.project.inventorymgmt.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njh.project.inventorymgmt.dto.SearchCriteria;
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

    @GetMapping("/productmgmt/list/search")
    public List<ProductDto> search(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject(request.getParameter("items"));

        String type = jsonObject.get("type").toString();
        String keyword = jsonObject.get("keyword").toString();
        String startDate = jsonObject.get("start_date").toString();
        String endDate = jsonObject.get("end_date").toString();

        SearchCriteria searchCriteria = new SearchCriteria();

        searchCriteria.setSearchCriteria(type, keyword, startDate, endDate);
        return productService.search(searchCriteria);
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

    @PostMapping("/productmgmt/delete")
    public Boolean delete(@RequestParam Long[] seqs) {
        
        try {
            productService.delete(seqs);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
}
