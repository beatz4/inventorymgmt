package com.njh.project.inventorymgmt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.service.CompanyService;


@Controller
public class CompanyViewController {
    
    // view
    @GetMapping("/companymgmt")
    public String getCompanyView() {
        return "companymgmt";
    }
    
}
