package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.exceptions.InvalidInvoiceException;
import com.solvd.laba.oop.legalOffice.exceptions.PaymentFailedException;
import com.solvd.laba.oop.legalOffice.interfaces.Payable;
import com.solvd.laba.oop.legalOffice.interfaces.Signable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

public final class Invoice implements Signable, Payable {
    private static final Logger logger = (Logger) LogManager.getLogger(Application.class);
    private static int initialInvoiceNumber = 1000;
    private static int invoiceNumberCounter = 0;
    private final int invoiceNumber;
    private Date dueDate;
    private Case legalCase;
    private Map<Integer, Double> invoiceInfo; // Integer - номер рахунку, Double - сума оплати

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

    public Map<Integer, Double> getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(Map<Integer, Double> invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    @Override
    public final double makePayment() {
        double basePrice = 1000;
        double experienceFactor = 1 + (legalCase.getLawyer().getExperienceYears() / 10.0);
        double complexityFactor = 1 + (legalCase.getCaseComplexity() / 10.0);

        return basePrice * experienceFactor * complexityFactor;
    }

    private void validateInvoice() throws InvalidInvoiceException {
        if (invoiceNumber <= 0 || dueDate == null || legalCase == null || legalCase.getClient() == null || makePayment() <= 0) {
            throw new InvalidInvoiceException("Invoice " + invoiceNumber + " has some wrong data.");
        }
    }

    public void issueInvoice() throws InvalidInvoiceException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("invoice.txt"))) {
            validateInvoice();

            writer.println("Invoice Information:");
            writer.println("Invoice Number: " + invoiceNumber);
            writer.println("Invoice Date: " + dueDate);
            writer.println("Case number: " + legalCase.getCaseNumber());
            writer.println("Client payer: " + legalCase.getClient().firstName + " " + legalCase.getClient().lastName);
            writer.println("Amount: " + makePayment() + " $");
            writer.println("----------------------------");
        } catch (InvalidInvoiceException | IOException e) {
            System.out.println();
            logger.error("Invalid invoice: " + e.getMessage() + "\n");
        }
    }

    @Override
    public void sign(Client client) {
        System.out.println("Invoice signed by " + client.firstName + " " + client.lastName + ".");
        System.out.println("----------------------------");
    }

    public void processPayment(double money) throws PaymentFailedException {
        try {
            double amount = makePayment();
            if (money == amount) {
                System.out.println("Was paid.");
                System.out.println("----------------------------");
            }
            if (money < amount) {
                throw new PaymentFailedException("Wasn't paid (not enough money).");
            }
        } catch (PaymentFailedException e) {
            System.out.println();
            logger.error("Payment failed: " + e.getMessage() + "\n");
        }
    }
}