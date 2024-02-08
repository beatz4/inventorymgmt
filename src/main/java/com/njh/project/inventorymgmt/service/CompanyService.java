package com.njh.project.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njh.project.inventorymgmt.dto.AddressDto;
import com.njh.project.inventorymgmt.dto.CompanyDto;
import com.njh.project.inventorymgmt.dto.SearchCriteria;
import com.njh.project.inventorymgmt.entity.Address;
import com.njh.project.inventorymgmt.entity.Company;
import com.njh.project.inventorymgmt.exception.NotFoundAddressException;
import com.njh.project.inventorymgmt.exception.NotFoundException;
import com.njh.project.inventorymgmt.repository.AddressRepository;
import com.njh.project.inventorymgmt.repository.CompanyRepository;
import com.njh.project.inventorymgmt.repository.CompanySpecification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CompanyService {
    
    CompanyRepository companyRepository;
    AddressRepository addressRepository;

    CompanyService(CompanyRepository companyRepository, AddressRepository addressRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
    }

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
                .updatedDate(x.getUpdatedDate())
            .build()).collect(Collectors.toList());
    }

    public List<CompanyDto> search(SearchCriteria searchCriteria) {

        Specification<Company> spec = Specification.where(CompanySpecification.search(searchCriteria));

        return companyRepository.findAll(spec).stream().map(x -> 
            CompanyDto.builder()
                .seq(x.getSeq())
                .name(x.getName())
                .code(x.getCode())
                .address(x.getAddress())
                .phone(x.getPhone())
                .email(x.getEmail())
                .createdDate(x.getCreatedDate())
                .updatedDate(x.getUpdatedDate())
            .build()).collect(Collectors.toList());
    }

    @Transactional
    public boolean save(Long seq, String name, String code, String phone, String email, AddressDto addressDto) {

        try {

            if (seq == null) {
                log.error("Invalid seq parameter");
                return false;
            }

            Optional<Company> companyEntity = companyRepository.findById(seq);

            if (companyEntity.isPresent()) {

                // 주소 데이터 변경
                Optional<Address> address = addressRepository.findById(companyEntity.get().getAddress().getSeq());

                if (address.isPresent()) {
                    address.get().changeAddressData(addressDto);
                    addressRepository.save(address.get());
                } else {
                    throw new NotFoundAddressException("company info : " + seq);
                }
                
                companyEntity.get().changeCompanyData(name, code, phone, email);
                companyRepository.save(companyEntity.get());

            } else {

                Address address = addressRepository.save(AddressDto.toEntity(addressDto));
                companyRepository.save(new Company(name, code, phone, email, address));
            }
            
        } catch (Exception e) {
            log.error("Occured something wrong in save function...");
        }

        return true;
    }

    @Transactional
    public void delete(Long []seqs) throws NotFoundException {

        try {
            companyRepository.deleteBySeqIn(seqs);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
