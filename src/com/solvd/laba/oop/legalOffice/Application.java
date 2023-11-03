package com.solvd.laba.oop.legalOffice;

public class Application {
    public static void main(String[] args) {

        Court court = new Court("Central Civil Court", "city Kyiv", CourtType.CIVIL_COURT);
        court.printDetails();

        ContactInfo lawyerContact = new ContactInfo("123456789", "mikejonson@example.com");
        Lawyer lawyerMike = new Lawyer("Mike", "Johnson", "35", "Senior Lawyer", 7000.0, 10,
                lawyerContact, "License567453", LawyerSpecializationType.CIVIL_LAW);
        lawyerMike.displayInfo();

        ContactInfo clientContact = new ContactInfo("987654321", "client@example.com");
        Client clientAlice = new Client("Alice", "Smith", "25", "Legal advice in civil law field", clientContact);
        clientAlice.displayInfo();

        Case caseAlice = new Case(1452, clientAlice, lawyerMike, "Needs property protection in the form of an apartment", 5);
        caseAlice.displayInfo();

        Document document = new Document(DocumentType.STATEMENT, "Claim for recognition of property ownership in the order of inheritance");
        document.printDetails();
        document.signDocument(clientAlice);
        document.submitToCourt(court);

        court.issueCourtDecision(caseAlice, document, "Ownership is recognized");
        caseAlice.closeCase();

        Invoice invoice = new Invoice(1452,caseAlice);
        invoice.issueInvoice();

    }
}
