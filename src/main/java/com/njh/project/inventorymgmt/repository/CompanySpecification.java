package com.njh.project.inventorymgmt.repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.njh.project.inventorymgmt.dto.CompanySearchCriteria;
import com.njh.project.inventorymgmt.entity.Company;

import jakarta.persistence.criteria.Predicate;

public class CompanySpecification {

    public static Specification<Company> search(CompanySearchCriteria criteria) {

        return (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            // 기간 검색
            if (criteria.getStartDate() != null && criteria.getEndDate() == null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("createdDate"), criteria.getStartDate()));
            } else if (criteria.getStartDate() == null && criteria.getEndDate() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("createdDate"), criteria.getEndDate()));
            } else if (criteria.getStartDate() != null && criteria.getEndDate() != null) {
                predicates.add(builder.between(root.get("createdDate"),
                        criteria.getStartDate(),
                        criteria.getEndDate()
                ));
            } else {
                predicates.add(builder.lessThanOrEqualTo(root.get("createdDate"), Instant.now()));
            }

            // 조건 검색
            switch (criteria.getType()) {
                case "company_name":
                    predicates.add(builder.like(root.get("name"), "%" + criteria.getKeyword() + "%"));
                break;
                case "company_phone":
                    predicates.add(builder.like(root.get("phone"), "%" + criteria.getKeyword() + "%"));
                break;
                case "company_email":
                    predicates.add(builder.like(root.get("email"), "%" + criteria.getKeyword() + "%"));
                break;
                default:
                    predicates.add(builder.or(
                        builder.like(root.get("name"), "%" + criteria.getKeyword() + "%"),
                        builder.like(root.get("phone"), "%" + criteria.getKeyword() + "%"),
                        builder.like(root.get("email"), "%" + criteria.getKeyword() + "%")
                    ));
                break;
            }
            
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
