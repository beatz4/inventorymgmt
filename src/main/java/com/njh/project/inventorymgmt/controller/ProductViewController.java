package com.njh.project.inventorymgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductViewController {

    @GetMapping("/productmgmt")
    public String getInventoryView() {
        return "/productmgmt";
    }
}
