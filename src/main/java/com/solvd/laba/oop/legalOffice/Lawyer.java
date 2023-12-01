package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.enums.LawyerSpecializationType;
import com.solvd.laba.oop.legalOffice.interfaces.Payable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class Lawyer extends Employee implements Payable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Lawyer.class);
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
        double bonus = this.getRandomBonus(Math::random);

        return baseSalary * experienceFactor + bonus;
    }

    public final void takeSalary() {
        LOGGER.info("Salary Information:");
        LOGGER.info("Lawyer: " + getFirstName() + " " + getLastName());
        LOGGER.info("Amount: " + makePayment() + " $");
        LOGGER.info("----------------------------");
    }

    public double getRandomBonus(Supplier<Double> randomBonusGenerator) {
        return randomBonusGenerator.get();
    }

    public boolean isSpecialized(BiPredicate<Lawyer, LawyerSpecializationType> specializationChecker, LawyerSpecializationType specializationType) {
        return specializationChecker.test(this, specializationType);
    }
}