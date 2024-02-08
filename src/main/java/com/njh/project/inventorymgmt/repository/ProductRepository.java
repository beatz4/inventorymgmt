package com.njh.project.inventorymgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.njh.project.inventorymgmt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    public List<Product> findBySeqIn(Long[] seqs);
    public void deleteBySeqIn(Long[] seqs);   
}
