package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.enums.CaseStatus;
import com.solvd.laba.oop.legalOffice.exceptions.InvalidCaseException;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;
import com.solvd.laba.oop.legalOffice.interfaces.Reviewable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public final class Case implements Printable, Reviewable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Application.class);
    private static int initialCaseNumber = 1000;
    private static int caseNumberCounter = 0;
    private final int caseNumber;
    private Client client;
    private Lawyer lawyer;
    private String caseDescription;
    private CaseStatus caseStatus;
    private int caseComplexity;
    private Queue<String> caseProcessingQueue;

    static {
        caseNumberCounter = initialCaseNumber;
    }

    public Case(Client client, Lawyer lawyer, String caseDescription, int caseComplexity) {
        this.client = client;
        this.lawyer = lawyer;
        this.caseDescription = caseDescription;
        this.caseComplexity = caseComplexity;
        this.caseNumber = caseNumberCounter++;
        openReview();
        this.caseProcessingQueue = new LinkedList<>();
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }

    public int getCaseComplexity() {
        return caseComplexity;
    }

    public void setCaseComplexity(int caseComplexity) {
        this.caseComplexity = caseComplexity;
    }

    public Queue<String> getCaseProcessingQueue() {
        return caseProcessingQueue;
    }

    public void setCaseProcessingQueue(Queue<String> caseProcessingQueue) {
        this.caseProcessingQueue = caseProcessingQueue;
    }

    public void addToProcessingQueue(String task) {
        caseProcessingQueue.offer(task);
        System.out.println("Task added to the processing queue for Case " + caseNumber + ": " + task);
    }

    public void processQueue() {
        System.out.println("Processing tasks in the queue for Case " + caseNumber + ":");
        while (!caseProcessingQueue.isEmpty()) {
            String task = caseProcessingQueue.poll();
            System.out.println("Processing task: " + task);
        }
        System.out.println("All tasks processed for Case " + caseNumber);
        System.out.println("----------------------------");
    }

    private void validateCase() throws InvalidCaseException {
        if (client == null || lawyer == null || caseDescription == null || caseDescription.trim().isEmpty()) {
            throw new InvalidCaseException("Client, lawyer, or case description is null or empty.");
        }

        if (caseComplexity < 1 || caseComplexity > 10) {
            throw new InvalidCaseException("Case complexity should be greater than 0, and lower than 11.");
        }
    }

    @Override
    public void openReview() {
        try {
            validateCase();

            this.setCaseStatus(CaseStatus.IN_REVIEW);
            System.out.println("Case number " + caseNumber + " is opened. Status: " + getCaseStatus());
            System.out.println("----------------------------");
        } catch (InvalidCaseException e) {
            System.out.println();
            LOGGER.error("Invalid case: " + e.getMessage() + "\n");
        }
    }

    @Override
    public void closeReview() {
        this.setCaseStatus(CaseStatus.CLOSED);
        System.out.println("Case number " + caseNumber + " is closed.");
        System.out.println("----------------------------");
    }

    @Override
    public void printDetails() {
        System.out.println("Case Information:");
        System.out.println("Case Number: " + caseNumber);
        System.out.println("Case Description: " + caseDescription);
        System.out.println("Case Status: " + caseStatus);
        System.out.println("Case Complexity: " + caseComplexity);
        System.out.println("Client: " + client.getFirstName() + " " + client.getLastName());
        System.out.println("Lawyer: " + lawyer.getFirstName() + " " + lawyer.getLastName());
        System.out.println("----------------------------");
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseNumber=" + caseNumber +
                ", client=" + client +
                ", lawyer=" + lawyer +
                ", caseDescription='" + caseDescription + '\'' +
                ", caseStatus=" + caseStatus +
                ", caseComplexity=" + caseComplexity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return caseNumber == aCase.caseNumber && caseComplexity == aCase.caseComplexity && Objects.equals(client, aCase.client) && Objects.equals(lawyer, aCase.lawyer) && Objects.equals(caseDescription, aCase.caseDescription) && caseStatus == aCase.caseStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, client, lawyer, caseDescription, caseStatus, caseComplexity);
    }
}