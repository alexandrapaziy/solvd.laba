package com.solvd.laba.oop.legalOffice;

import java.util.Objects;

public class Lawyer extends Employee implements Payable {
    private final String license;
    private LawyerSpecializationType specialization;

    public Lawyer(String firstName, String lastName, int age, String position, int experienceYears,
                  ContactInfo contactInfo, String license, LawyerSpecializationType specialization) {
        super(firstName, lastName, age, position, experienceYears, contactInfo);
        this.license = license;
        this.specialization = specialization;
    }

    public String getLicense() {
        return license;
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

    @Override
    public final double makePayment() {
        double baseSalary = 5000.0;
        double experienceFactor = 1 + (getExperienceYears() / 10.0);

        return baseSalary * experienceFactor;
    }

    public final void takeSalary() {
        System.out.println("Salary Information:");
        System.out.println("Lawyer: " + getFirstName() + " " + getLastName());
        System.out.println("Amount: " + makePayment() + " $");
        System.out.println("----------------------------");
    }
}