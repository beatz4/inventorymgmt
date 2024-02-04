package com.njh.project.inventorymgmt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.dto.CompanySearchCriteria;
import com.njh.project.inventorymgmt.entity.CompanyEntity;
import com.njh.project.inventorymgmt.exception.InvalidArgumentException;
import com.njh.project.inventorymgmt.exception.NotExistException;
import com.njh.project.inventorymgmt.repository.CompanyRepository;
import com.njh.project.inventorymgmt.repository.CompanySpecification;

@Service
@Transactional
public class CompanyService {
    
    @Autowired
    CompanyRepository companyRepository;

    public List<CompanyDto> getList() {

        return companyRepository.findAll().stream().map(x -> 
            CompanyDto.builder()
                .seq(x.getSeq())
                .name(x.getName())
                .code(x.getCode())
                .address(x.getAddress())
                .phone(x.getPhone())
                .email(x.getEmail())
                .createdDate(x.getCreatedDate())
            .build()).collect(Collectors.toList());
    }

    public List<CompanyDto> search(CompanySearchCriteria companySearchCriteria) {

        Specification<CompanyEntity> spec = Specification.where(CompanySpecification.search(companySearchCriteria));

        return companyRepository.findAll(spec).stream().map(x -> 
            CompanyDto.builder()
                .seq(x.getSeq())
                .name(x.getName())
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
            companyRepository.deleteBySeqIn(seqs);
        } catch (Exception e) {
            throw new NotExistException(e.getMessage());
        }
    }
}
