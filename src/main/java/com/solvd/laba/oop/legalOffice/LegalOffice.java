package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.interfaces.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class LegalOffice extends LegalEntity implements Printable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Application.class);
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
        LOGGER.info("Legal Office Details:");
        LOGGER.info("Name: " + getEntityName());
        LOGGER.info("Address: " + getAddress());
        LOGGER.info("Employees: ");
        for (Employee employee : employees) {
            employee.printDetails();
        }
        LOGGER.info("----------------------------");
    }
}