package com.njh.project.inventorymgmt.service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

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

        return companyRepository.findAll().stream().map(x -> 
            CompanyDto.builder()
                .seq(x.getSeq())
                .code(x.getCode())
                .address(x.getAddress())
                .email(x.getEmail())
                .createdDate(x.getCreatedDate())
            .build()).collect(Collectors.toList());
    }
}
