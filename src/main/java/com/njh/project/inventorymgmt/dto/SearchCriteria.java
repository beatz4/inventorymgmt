package com.njh.project.inventorymgmt.dto;

import java.time.Instant;

import com.njh.project.inventorymgmt.utils.Utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchCriteria {

    private String type;
    private String keyword;
    private Instant startDate;
    private Instant endDate;

    public void setSearchCriteria(String type, String keyword, String startDate, String endDate) {
        this.type = type;
        this.keyword = keyword;
        this.startDate = Utils.convertDateType(startDate);
        this.endDate = Utils.convertDateType(endDate);
    }
}
