package com.njh.project.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.njh.project.inventorymgmt.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    
}
