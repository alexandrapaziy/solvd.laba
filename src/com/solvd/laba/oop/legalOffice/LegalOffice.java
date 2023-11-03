package com.solvd.laba.oop.legalOffice;

import java.util.List;

public class LegalOffice extends LegalEntity {
    private List<Employee> employees;

    public LegalOffice(String entityName, String address, List<Employee> employees) {
        super(entityName, address);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void printDetails() {
        System.out.println("Legal Office Details:");
        System.out.println("Name: " + getEntityName());
        System.out.println("Address: " + getAddress());
        System.out.println("Employees: ");
        for (Employee employee : employees) {
            employee.displayInfo();
        }
        System.out.println("----------------------------");
    }
}