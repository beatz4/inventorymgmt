package com.njh.project.inventorymgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.njh.project.inventorymgmt.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>, JpaSpecificationExecutor<CompanyEntity> {

    public List<CompanyEntity> findBySeqIn(Long[] seqs);
    public void deleteBySeqIn(Long[] seqs);
}
