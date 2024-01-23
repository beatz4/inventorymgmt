package com.njh.project.inventorymgmt.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.repository.CompanyRepository;

@Service
@Transactional
public class CompanyService {
    
    @Autowired
    CompanyRepository companyRepository;

    public List<CompanyDto> getList() {

        List<CompanyDto> result = new ArrayList<>();

        // companyRepository.findAll().stream().map(x ->
        //     x.get
        // );

        // CompanyDto.builder()
        //     .seq(null)
        

        return null;
    }
}
