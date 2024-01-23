package com.njh.project.inventorymgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.njh.project.inventorymgmt.dto.CompanyDto;

@Controller
public class CompanyController {
    
    // view
    @GetMapping("/companymgmt")
    public String getCompanyView() {
        return "/companymgmt";
    }
    
    // api
    @GetMapping("/list")
    public List<CompanyDto> getList() {

        List<CompanyDto> result = new ArrayList<>();

        return result;
    }
    
}
