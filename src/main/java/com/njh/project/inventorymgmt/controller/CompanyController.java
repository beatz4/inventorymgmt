package com.njh.project.inventorymgmt.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njh.project.inventorymgmt.dto.AddressDto;
import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.dto.CompanySearchCriteria;
import com.njh.project.inventorymgmt.exception.NotFoundException;
import com.njh.project.inventorymgmt.service.CompanyService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    
    @GetMapping("/companymgmt/list")
    public List<CompanyDto> getList() {
        return companyService.getList();
    }

    @GetMapping("/companymgmt/list/search")
    public List<CompanyDto> search(HttpServletRequest request) {

        JSONObject jsonObject = new JSONObject(request.getParameter("items"));

        String type = jsonObject.get("type").toString();
        String keyword = jsonObject.get("keyword").toString();
        String startDate = jsonObject.get("start_date").toString();
        String endDate = jsonObject.get("end_date").toString();

        CompanySearchCriteria companySearchCriteria = new CompanySearchCriteria();

        companySearchCriteria.setSearchCriteria(type, keyword, startDate, endDate);
        return companyService.search(companySearchCriteria);
    }

    @PostMapping("/companymgmt/save")
    public Boolean save(HttpServletRequest request) {

        JSONObject jsonObject = new JSONObject(request.getParameter("items"));

        Long seq = -1L;
        if (jsonObject.has("seq") && !jsonObject.get("seq").toString().isEmpty()) {
            seq = Long.parseLong(jsonObject.get("seq").toString());
        }
        String name = jsonObject.get("name").toString();
        String code = jsonObject.get("code").toString();
        String email = jsonObject.get("email").toString();
        String phone = jsonObject.get("phone").toString();

        // address
        Integer zipcode = Integer.parseInt(jsonObject.get("zipcode").toString());
        String roadAddress = jsonObject.get("roadAddress").toString();
        String jibunAddress = jsonObject.get("jibunAddress").toString();
        String detailAddress = jsonObject.get("detailAddress").toString();
        String extraAddress = jsonObject.get("extraAddress").toString();

        try {
            companyService.save(seq, name, code, phone, email, 
                AddressDto.builder()
                    .zipcode(zipcode)
                    .roadAddress(roadAddress)
                    .jibunAddress(jibunAddress)
                    .detailAddress(detailAddress)
                    .extraAddress(extraAddress)
                .build());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    
    @PostMapping("/companymgmt/delete")
    public Boolean delete(@RequestParam Long[] seqs) {

        try {
            companyService.delete(seqs);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
}
