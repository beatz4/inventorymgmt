package com.njh.project.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.njh.project.inventorymgmt.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
