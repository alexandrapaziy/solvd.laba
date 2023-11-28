package com.solvd.laba.oop.legalOffice.enums;

public enum LawyerSpecializationType {
    CIVIL_LAW("Deals with civil matters", 2),
    CRIMINAL_LAW("Handles criminal cases", 3),
    FAMILY_LAW("Specializes in family-related legal issues", 1);

    private final String description;
    private final int experienceLevel;

    LawyerSpecializationType(String description, int experienceLevel) {
        this.description = description;
        this.experienceLevel = experienceLevel;
    }

    public String getDescription() {
        return description;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }
}