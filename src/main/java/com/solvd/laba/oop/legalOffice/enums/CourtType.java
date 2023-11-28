package com.solvd.laba.oop.legalOffice.enums;

public enum CourtType {
    CIVIL_COURT(""),
    CRIMINAL_COURT(""),
    APPELLATE_COURT("");

    private String description;

    {
        switch (this) {
            case CIVIL_COURT:
                description = "Handles civil cases. Deals with private disputes.";
                break;
            case CRIMINAL_COURT:
                description = "Handles criminal cases. Deals with criminal offenses.";
                break;
            case APPELLATE_COURT:
                description = "Hears appeals from lower courts. Reviews decisions from lower courts.";
                break;
        }
    }

    CourtType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}