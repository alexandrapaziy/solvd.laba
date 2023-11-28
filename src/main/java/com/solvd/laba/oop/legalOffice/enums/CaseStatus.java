package com.solvd.laba.oop.legalOffice.enums;

public enum CaseStatus {
    IN_REVIEW("Case is currently under review"),
    IN_COURT("Case is in court proceedings"),
    CLOSED("Case has been closed");

    private final String description;

    CaseStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isClosed() {
        return this == CLOSED;
    }
}