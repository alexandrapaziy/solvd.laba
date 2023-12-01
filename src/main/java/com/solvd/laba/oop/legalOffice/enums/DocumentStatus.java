package com.solvd.laba.oop.legalOffice.enums;

public enum DocumentStatus {
    DEVELOPMENT("Document is in development"),
    SIGNED("Document has been signed"),
    SUBMITTED("Document has been submitted"),
    CLOSED("Document is closed");

    private final String description;

    DocumentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSigned() {
        return this == SIGNED;
    }
}