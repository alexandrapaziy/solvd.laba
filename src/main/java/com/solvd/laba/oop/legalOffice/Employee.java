package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.interfaces.Contactable;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;

public class Employee extends Person implements Printable, Contactable {
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
        System.out.println("Employee Information:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Position: " + position);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("----------------------------");
    }

    @Override
    public void getContacts() {
        System.out.println("Contacts:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Phone: " + contactInfo.getPhone());
        System.out.println("Email: " + contactInfo.getEmail());
        System.out.println("----------------------------");
    }

    public static final int getEmployeeCount() {
        System.out.println("Total employee count: " + employeeCount);
        System.out.println("----------------------------");
        return employeeCount;
    }
}