package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.enums.CaseStatus;
import com.solvd.laba.oop.legalOffice.enums.CourtType;
import com.solvd.laba.oop.legalOffice.enums.DocumentStatus;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;
import com.solvd.laba.oop.legalOffice.list.CustomLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Court extends LegalEntity implements Printable {
    private CourtType courtType;
    private CustomLinkedList<Case> cases;

    public Court(String entityName, String address, CourtType courtType) {
        super(entityName, address);
        this.courtType = courtType;
        this.cases = new CustomLinkedList<>();
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public void addCaseToCourt(Case legalCase) {
        cases.add(legalCase);
        System.out.println("Case " + legalCase.getCaseNumber() + " added to the court.");
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
        System.out.println("Cases in Court:");
        for (int i = 0; i < cases.size(); i++) {
            Case legalCase = cases.get(i);
            System.out.println("Case Number: " + legalCase.getCaseNumber());
        }
        System.out.println("----------------------------");
    }
}