package com.njh.project.inventorymgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.njh.project.inventorymgmt.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company> {

    public List<Company> findBySeqIn(Long[] seqs);
    public void deleteBySeqIn(Long[] seqs);
}
