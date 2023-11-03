package com.solvd.laba.oop.legalOffice;

import java.util.Date;

public class Invoice {
    private int invoiceNumber;
    private Date dueDate;

    private Case legalCase;

    public Invoice(int invoiceNumber, Case legalCase) {
        this.invoiceNumber = invoiceNumber;
        this.dueDate = new Date();
        this.legalCase = legalCase;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Case getLegalCase() {
        return legalCase;
    }

    public void setLegalCase(Case legalCase) {
        this.legalCase = legalCase;
    }

    public double calculateServicePrice() {
        double basePrice = 100;
        double experienceFactor = 1 + (legalCase.getLawyer().getExperienceYears() / 10.0);
        double complexityFactor = 1 + (legalCase.getCaseComplexity() / 10.0);

        return basePrice * experienceFactor * complexityFactor;
    }

    public void issueInvoice() {
        System.out.println("Invoice Information:");
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Invoice Date: " + dueDate);
        System.out.println("Case number: " + legalCase.getCaseNumber());
        System.out.println("Client payer: " + legalCase.getClient().firstName + " " + legalCase.getClient().lastName);
        System.out.println("Amount: " + calculateServicePrice() + " $");
        System.out.println("----------------------------");
    }
}