package com.njh.project.inventorymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.service.CompanyService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;
    
     // api
    @GetMapping("/companymgmt/list")
    public List<CompanyDto> getList() {

        return companyService.getList();
    }

    @PostMapping("/companymgmt/add")
    public Boolean save(HttpServletRequest request) {

        
        return true;
    }
    
}
