package com.solvd.laba.oop.legalOffice;

import java.util.Objects;

public final class Case implements Printable, Reviewable {
    private static int initialCaseNumber = 1000;
    private static int caseNumberCounter = 0;
    private final int caseNumber;
    private Client client;
    private Lawyer lawyer;
    private String caseDescription;
    private CaseStatus caseStatus;
    private int caseComplexity;

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

    @Override
    public void openReview() {
        this.setCaseStatus(CaseStatus.IN_REVIEW);
        System.out.println("Case number " + caseNumber + " is opened. Status: " + getCaseStatus());
        System.out.println("----------------------------");
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