package com.njh.project.inventorymgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.entity.CompanyEntity;
import com.njh.project.inventorymgmt.exception.InvalidArgumentException;
import com.njh.project.inventorymgmt.exception.NotExistException;
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
                .phone(x.getPhone())
                .email(x.getEmail())
                .createdDate(x.getCreatedDate())
            .build()).collect(Collectors.toList());
    }

    @Transactional
    public boolean save(String name, String code, String address, String phone, String email) throws InvalidArgumentException {

        try {
            companyRepository.save(new CompanyEntity(name, code, address, phone, email));
        } catch (Exception e) {
            throw new InvalidArgumentException(e.getMessage());
        }

        return true;
    }

    @Transactional
    public void delete(Long []seqs) throws NotExistException {

        try {
            // companyRepository.findByIdIn(seqs);
            companyRepository.deleteBySeqIn(seqs);
        } catch (Exception e) {
            throw new NotExistException(e.getMessage());
        }
    }
}
