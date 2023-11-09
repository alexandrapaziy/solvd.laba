package com.solvd.laba.oop.legalOffice;

public class Court extends LegalEntity implements Printable {
    private CourtType courtType;

    public Court(String entityName, String address, CourtType courtType) {
        super(entityName, address);
        this.courtType = courtType;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public void issueCourtDecision(Case courtCase, Document courtDocument, String courtDecision) {
        if (courtDocument.getDocumentStatus() == DocumentStatus.SUBMITTED) {
            System.out.println("Court decision issued for Case number " + courtCase.getCaseNumber() + ": " + courtDecision);
            System.out.println("----------------------------");
            courtCase.setCaseStatus(CaseStatus.IN_COURT);
        } else {
            System.out.println("Cannot issue court decision. Document is not submitted to the court.");
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Court Details:");
        System.out.println("Court Name: " + getEntityName());
        System.out.println("Court Type: " + courtType);
        System.out.println("Address: " + getAddress());
        System.out.println("----------------------------");
    }

}