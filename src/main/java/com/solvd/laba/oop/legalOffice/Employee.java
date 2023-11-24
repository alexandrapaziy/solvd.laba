package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.interfaces.Contactable;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Employee extends Person implements Printable, Contactable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Employee.class);
    private static int employeeCount = 0;
    protected String position;
    protected int experienceYears;
    private ContactInfo contactInfo;

    public Employee(String firstName, String lastName, int age, String position, int experienceYears, ContactInfo contactInfo) {
        super(firstName, lastName, age);
        this.position = position;
        this.experienceYears = experienceYears;
        this.contactInfo = contactInfo;
        employeeCount++;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public void printDetails() {
        LOGGER.info("Employee Information:");
        LOGGER.info("Name: " + getFirstName() + " " + getLastName());
        LOGGER.info("Position: " + position);
        LOGGER.info("Experience: " + experienceYears + " years");
        LOGGER.info("----------------------------");
    }

    @Override
    public void getContacts() {
        LOGGER.info("Contacts:");
        LOGGER.info("Name: " + getFirstName() + " " + getLastName());
        LOGGER.info("Phone: " + contactInfo.getPhone());
        LOGGER.info("Email: " + contactInfo.getEmail());
        LOGGER.info("----------------------------");
    }

    public static final int getEmployeeCount() {
        LOGGER.info("Total employee count: " + employeeCount);
        LOGGER.info("----------------------------");
        return employeeCount;
    }
}