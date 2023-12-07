package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.enums.CaseStatus;
import com.solvd.laba.oop.legalOffice.enums.CourtType;
import com.solvd.laba.oop.legalOffice.enums.DocumentStatus;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;
import com.solvd.laba.oop.legalOffice.list.CustomLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Court extends LegalEntity implements Printable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Court.class);
    private CourtType courtType;
    private LinkedList<Case> cases;

    public Court(String entityName, String address, CourtType courtType) {
        super(entityName, address);
        this.courtType = courtType;
        this.cases = new LinkedList<>();
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public LinkedList<Case> getCases() {
        return cases;
    }

    public void setCases(LinkedList<Case> cases) {
        this.cases = cases;
    }

    public void addCaseToCourt(Case legalCase) {
        cases.add(legalCase);
        LOGGER.info("Case " + legalCase.getCaseNumber() + " added to the court.");
    }

    public void issueCourtDecision(Case courtCase, Document courtDocument, String courtDecision) {
        if (courtDocument.getDocumentStatus() == DocumentStatus.SUBMITTED) {
            LOGGER.info("Court decision issued for Case number " + courtCase.getCaseNumber() + ": " + courtDecision);
            LOGGER.info("----------------------------");
            courtCase.setCaseStatus(CaseStatus.IN_COURT);
        } else {
            LOGGER.info("Cannot issue court decision. Document is not submitted to the court.");
        }
    }

    @Override
    public void printDetails() {
        LOGGER.info("Court Details:");
        LOGGER.info("Court Name: " + getEntityName());
        LOGGER.info("Court Type: " + courtType);
        LOGGER.info("Address: " + getAddress());
        LOGGER.info("----------------------------");
        LOGGER.info("Cases in Court:");

        String caseNumbers = cases.stream()
                .map(legalCase -> String.valueOf(legalCase.getCaseNumber()))
                .collect(Collectors.joining(", "));

        LOGGER.info("Cases in Court: " + caseNumbers);
        LOGGER.info("----------------------------");
    }
}