package com.solvd.laba.oop.legalOffice;

public class Employee extends Person{
    protected String position;
    protected double salary;
    protected int experienceYears;
    private ContactInfo contactInfo;

    public Employee(String firstName, String lastName, String age, String position, double salary, int experienceYears, ContactInfo contactInfo) {
        super(firstName, lastName, age);
        this.position = position;
        this.salary = salary;
        this.experienceYears = experienceYears;
        this.contactInfo = contactInfo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
    public void displayInfo() {
        System.out.println("Employee Information:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Contact Information: " + contactInfo.getPhone() + ", " + contactInfo.getEmail());
        System.out.println("----------------------------");
    }
}