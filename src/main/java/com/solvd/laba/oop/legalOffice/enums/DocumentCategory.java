package com.solvd.laba.oop.legalOffice.enums;

public enum DocumentCategory {
    LEGAL("Legal documents"),
    FINANCIAL("Financial documents"),
    PERSONAL("Personal documents");

    private final String description;

    DocumentCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}