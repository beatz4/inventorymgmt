package com.njh.project.inventorymgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyViewController {
    
    // view
    @GetMapping("/companymgmt")
    public String getCompanyView() {
        return "companymgmt";
    }
    
}
