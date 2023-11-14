package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.interfaces.Printable;

import java.util.List;

public class LegalOffice extends LegalEntity implements Printable {
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
            employee.printDetails();
        }
        System.out.println("----------------------------");
    }
}