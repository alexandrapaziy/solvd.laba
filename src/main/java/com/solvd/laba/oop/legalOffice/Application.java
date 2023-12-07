package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.enums.CaseStatus;
import com.solvd.laba.oop.legalOffice.enums.CourtType;
import com.solvd.laba.oop.legalOffice.enums.DocumentType;
import com.solvd.laba.oop.legalOffice.enums.LawyerSpecializationType;
import com.solvd.laba.oop.legalOffice.exceptions.InvalidContactInfoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.*;

import static com.solvd.laba.oop.legalOffice.Client.getClientCount;
import static com.solvd.laba.oop.legalOffice.Employee.getEmployeeCount;

public class Application {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Application.class);

    public static void main(String[] args) throws InvalidContactInfoException {
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

        long employeeCount = office.getEmployees().stream().count();
        LOGGER.info("Number of employees: " + employeeCount);

        office.getEmployees().stream()
                .filter(employee -> employee.getAge() > 30)
                .map(Employee::getFirstName)
                .forEach(firstName -> LOGGER.info("Employee name: " + firstName));

        office.getEmployees().stream()
                .filter(employee -> employee.getExperienceYears() > 5)
                .filter(employee -> employee.getPosition().equals("Senior Lawyer"))
                .forEach(employee -> {
                    LOGGER.info("Employee: " + employee.getFirstName() + " " + employee.getLastName());
                    LOGGER.info("Experience Years: " + employee.getExperienceYears());
                    LOGGER.info("Position: " + employee.getPosition());
                });

        lawyerMike.getContacts();

        ContactInfo clientContact = new ContactInfo("987654321", "alicesmith@example.com");
        Set<ContactInfo> clientContacts = new HashSet<>();
        clientContacts.add(clientContact);

        Client clientAlice = new Client("Alice", "Smith", 25, "Legal advice in civil law field", clientContacts);
        clientAlice.printDetails();
        int length = clientAlice.getFullNameLength(client -> client.getFirstName() + " " + client.getLastName());
        LOGGER.info("Client full name length is: " + length);
        clientAlice.getContacts();

        clientAlice.performActionWithContactInfo(contactInfo -> {
            for (ContactInfo contact : contactInfo) {
                if (contact != null) {
                    LOGGER.info("Phone: " + contact.getPhone());
                } else {
                    LOGGER.warn("No contact information available.");
                }
            }
        });

        boolean isCivilLawSpecialist = lawyerMike.isSpecialized((lawyer, specialization) -> lawyer.getSpecialization() == specialization, LawyerSpecializationType.CIVIL_LAW);
        if (isCivilLawSpecialist) {
            LOGGER.info("Lawyer" + lawyerMike.getFirstName() + " " + lawyerMike.getLastName() + " is specialist in civil law");
        } else {
            LOGGER.info("Lawyer" + lawyerMike.getFirstName() + " " + lawyerMike.getLastName() + " is not specialist in civil law");
        }

        Case caseAlice = new Case(null, lawyerMike, "Needs property protection in the form of an apartment", 3);
        caseAlice.setClient(clientAlice);
        caseAlice.printDetails();

        caseAlice.performActionWithClientLawyerAndCaseDescription((client, lawyer, caseDescription) ->
                LOGGER.info("Case details: Client - " + client.getFirstName() + " " + client.lastName +
                        ", Lawyer - " + lawyer.getFirstName() + " " + lawyer.getLastName() + ", Description - " + caseDescription));

        caseAlice.addToProcessingQueue("Gather evidence");
        caseAlice.addToProcessingQueue("Interview witnesses");
        caseAlice.addToProcessingQueue("Prepare legal documents");

        caseAlice.processQueue();

        getClientCount();
        int doubledComplexity = caseAlice.getDoubledComplexity(complexity -> complexity * 2);
        LOGGER.info("Еhe complexity of the case has been doubled because the case is going to court, now complexity is: " + doubledComplexity);

        Document document = new Document(null, "Claim for recognition of property ownership in the order of inheritance");
        document.printDetails();
        document.sign(clientAlice);
        document.setDocumentType(DocumentType.STATEMENT);
        document.sign(clientAlice);
        document.submitToCourt(court);

        court.addCaseToCourt(caseAlice);
        court.printDetails();

        boolean isInCourt = court.getCases().stream()
                .anyMatch(c -> c.getCaseStatus() == CaseStatus.IN_COURT);
        LOGGER.info("Is there any case in court? " + isInCourt);

        court.getCases().stream()
                .map(Case::getCaseDescription)
                .distinct()
                .forEach(description -> LOGGER.info("Case Description: " + description));

        double averageComplexity = court.getCases().stream()
                .mapToInt(Case::getCaseComplexity)
                .average()
                .orElse(0.0);
        LOGGER.info("Average case complexity: " + averageComplexity);

        Optional<Case> lastCase = court.getCases().stream()
                .max(Comparator.comparingInt(Case::getCaseNumber));

        lastCase.ifPresent(caseObject -> {
            LOGGER.info("Max Case Number: " + caseObject.getCaseNumber());
            LOGGER.info("Case Description: " + caseObject.getCaseDescription());
        });

        court.issueCourtDecision(caseAlice, document, "Ownership is recognized");
        document.closeReview();
        caseAlice.closeReview();

        Invoice invoice = new Invoice(null);
        invoice.issueInvoice();
        invoice.setLegalCase(caseAlice);
        invoice.issueInvoice();
        invoice.sign(clientAlice);

        boolean isEvenPayment = invoice.isPaymentEven(amount -> amount % 2 == 0);
        if (isEvenPayment) {
            LOGGER.info("Payment amount is even");
        } else {
            LOGGER.info("Payment amount is not even");
        }

        invoice.processPayment(300);
        invoice.processPayment(3000);

        invoice.performActionWithClientAndInvoiceNumber((client, invoiceNumber) ->
                LOGGER.info("Invoice " + invoiceNumber + " paid by " + client.firstName + " " + client.lastName));

        lawyerMike.takeSalary();
    }
}