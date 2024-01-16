package com.njh.project.inventorymgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InventoryController {
    
    @GetMapping("/inventorymgmt")
    public String getInventoryView() {
        return "/inventorymgmt";
    }
    
}
