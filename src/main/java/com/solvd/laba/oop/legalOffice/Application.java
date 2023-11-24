package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.enums.CourtType;
import com.solvd.laba.oop.legalOffice.enums.DocumentType;
import com.solvd.laba.oop.legalOffice.enums.LawyerSpecializationType;
import com.solvd.laba.oop.legalOffice.exceptions.InvalidContactInfoException;
import com.solvd.laba.oop.legalOffice.exceptions.InvalidInvoiceException;
import com.solvd.laba.oop.legalOffice.exceptions.PaymentFailedException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.solvd.laba.oop.legalOffice.Client.getClientCount;
import static com.solvd.laba.oop.legalOffice.Employee.getEmployeeCount;

public class Application {

    public static void main(String[] args) throws PaymentFailedException, InvalidInvoiceException, InvalidContactInfoException {
        Court court = new Court("Central Civil Court", "city Kyiv", CourtType.CIVIL_COURT);

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
        Set<ContactInfo> clientContacts = new HashSet<>();
        clientContacts.add(clientContact);

        Client clientAlice = new Client("Alice", "Smith", 25, "Legal advice in civil law field", clientContacts);
        clientAlice.printDetails();
        clientAlice.getContacts();

        Case caseAlice = new Case(null, lawyerMike, "Needs property protection in the form of an apartment", 5);
        caseAlice.setClient(clientAlice);
        caseAlice.printDetails();

        caseAlice.addToProcessingQueue("Gather evidence");
        caseAlice.addToProcessingQueue("Interview witnesses");
        caseAlice.addToProcessingQueue("Prepare legal documents");

        caseAlice.processQueue();

        getClientCount();

        Document document = new Document(null, "Claim for recognition of property ownership in the order of inheritance");
        document.printDetails();
        document.sign(clientAlice);
        document.setDocumentType(DocumentType.STATEMENT);
        document.sign(clientAlice);
        document.submitToCourt(court);

        court.addCaseToCourt(caseAlice);
        court.printDetails();

        court.issueCourtDecision(caseAlice, document, "Ownership is recognized");
        document.closeReview();
        caseAlice.closeReview();

        Invoice invoice = new Invoice(null);
        invoice.issueInvoice();
        invoice.setLegalCase(caseAlice);
        invoice.issueInvoice();
        invoice.sign(clientAlice);

        invoice.processPayment(300);
        invoice.processPayment(3000);

        lawyerMike.takeSalary();
    }
}