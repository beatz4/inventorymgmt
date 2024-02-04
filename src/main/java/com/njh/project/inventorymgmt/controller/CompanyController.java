package com.njh.project.inventorymgmt.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.exception.NotExistException;
import com.njh.project.inventorymgmt.service.CompanyService;

import jakarta.servlet.http.HttpServletRequest;



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

        JSONObject jsonObject = new JSONObject(request.getParameter("items"));

        String name = jsonObject.get("name").toString();
        String address = jsonObject.get("address").toString();
        String code = jsonObject.get("code").toString();
        String email = jsonObject.get("email").toString();
        String phone = jsonObject.get("phone").toString();

        try {
            companyService.save(name, code, address, phone, email);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    
    @PostMapping("/companymgmt/delete")
    public Boolean delete(@RequestParam Long[] seqs) {

        try {
            companyService.delete(seqs);
        } catch (NotExistException e) {
            e.printStackTrace();
        }

        return true;
    }
    
}
