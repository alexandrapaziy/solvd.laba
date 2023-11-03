package com.solvd.laba.oop.legalOffice;

import java.util.Objects;

public class Lawyer extends Employee {
    private String license;
    private LawyerSpecializationType specialization;

    public Lawyer(String firstName, String lastName, String age, String position, double salary, int experienceYears,
                  ContactInfo contactInfo, String license, LawyerSpecializationType specialization) {
        super(firstName, lastName, age, position, salary, experienceYears, contactInfo);
        this.license = license;
        this.specialization = specialization;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public LawyerSpecializationType getSpecialization() {
        return specialization;
    }

    public void setSpecialization(LawyerSpecializationType specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "license='" + license + '\'' +
                ", specialization=" + specialization +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawyer lawyer = (Lawyer) o;
        return Objects.equals(license, lawyer.license) && specialization == lawyer.specialization;
    }

    @Override
    public int hashCode() {
        return Objects.hash(license, specialization);
    }
}