package com.sda.advanced.enums;

import java.util.Arrays;

public enum ConsentType {

    ACCEPTED("consent accepted"),
    REJECTED("consent rejected"),
    PENDING("consent pending");

    private String code;

    ConsentType(String code) {
        this.code = code;
    }

    public static ConsentType findConsentTypeByCode(String code) {
        return Arrays.stream(values())
            .filter(consentType -> consentType.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("no such consent type"));
    }

    public String getCode() {
        return code;
    }

}
