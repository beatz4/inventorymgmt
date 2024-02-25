package com.njh.project.inventorymgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OrderController {
    
    @GetMapping("/ordermgmt")
    public String getOrderView() {
        return "ordermgmt";
    }
    
}
