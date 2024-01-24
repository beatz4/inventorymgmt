package com.njh.project.inventorymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.service.CompanyService;

@RestController
public class CompanyController {

     @Autowired
    CompanyService companyService;
    
     // api
    @GetMapping("/companymgmt/list")
    public List<CompanyDto> getList() {

        return companyService.getList();
    }
}
