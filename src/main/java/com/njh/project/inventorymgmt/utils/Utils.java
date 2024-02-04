package com.njh.project.inventorymgmt.utils;

import java.time.Instant;

public class Utils {
    
    public static boolean isEmpty(Object obj) {
        return !(obj == null || obj.toString().isEmpty());
    }

    public static Instant convertDateType(String str) {
        if (str != null && !str.isEmpty()) {
            return Instant.parse(str);
        }

        return null;
    }
}
