package com.solvd.laba.oop.legalOffice;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.laba.oop.legalOffice.Client.getClientCount;
import static com.solvd.laba.oop.legalOffice.Employee.getEmployeeCount;

public class Application {
    public static void main(String[] args) {

        Court court = new Court("Central Civil Court", "city Kyiv", CourtType.CIVIL_COURT);
        court.printDetails();

        ContactInfo employeeContact = new ContactInfo("987654321", "mariajonson@example.com");
        Employee employeeMaria = new Employee("Maria", "Jonson", 24, "administrator", 3, employeeContact);

        ContactInfo lawyerContact = new ContactInfo("123456789", "mikejonson@example.com");
        Lawyer lawyerMike = new Lawyer("Mike", "Johnson", 35, "Senior Lawyer", 10,
                lawyerContact, "License567453", LawyerSpecializationType.CIVIL_LAW);

        List<Employee> employees = new ArrayList<>();
        employees.add(employeeMaria);
        employees.add(lawyerMike);

        LegalOffice office = new LegalOffice("LawOffice", "city Kyiv", employees);
        office.printDetails();

        getEmployeeCount();

        lawyerMike.getContacts();

        ContactInfo clientContact = new ContactInfo("987654321", "alicesmith@example.com");
        Client clientAlice = new Client("Alice", "Smith", 25, "Legal advice in civil law field", clientContact);
        clientAlice.printDetails();
        clientAlice.getContacts();

        Case caseAlice = new Case(clientAlice, lawyerMike, "Needs property protection in the form of an apartment", 5);
        caseAlice.printDetails();

        getClientCount();

        Document document = new Document(DocumentType.STATEMENT, "Claim for recognition of property ownership in the order of inheritance");
        document.printDetails();
        document.sign(clientAlice);
        document.submitToCourt(court);

        court.issueCourtDecision(caseAlice, document, "Ownership is recognized");
        document.closeReview();
        caseAlice.closeReview();

        Invoice invoice = new Invoice(caseAlice);
        invoice.issueInvoice();
        invoice.sign(clientAlice);

        lawyerMike.takeSalary();

    }
}
