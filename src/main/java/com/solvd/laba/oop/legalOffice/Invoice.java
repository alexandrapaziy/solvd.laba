package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.interfaces.Payable;
import com.solvd.laba.oop.legalOffice.interfaces.Signable;

import java.util.Date;

public final class Invoice implements Signable, Payable {
    private static int initialInvoiceNumber = 1000;
    private static int invoiceNumberCounter = 0;
    private final int invoiceNumber;
    private Date dueDate;
    private Case legalCase;

    static {
        invoiceNumberCounter = initialInvoiceNumber;
    }

    public Invoice(Case legalCase) {
        this.invoiceNumber = invoiceNumberCounter++;
        this.dueDate = new Date();
        this.legalCase = legalCase;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
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

    @Override
    public final double makePayment() {
        double basePrice = 1000;
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
        System.out.println("Amount: " + makePayment() + " $");
        System.out.println("----------------------------");
    }

    @Override
    public void sign(Client client) {
        System.out.println("Invoice signed by " + client.firstName + " " + client.lastName + ".");
        System.out.println("----------------------------");
    }

}