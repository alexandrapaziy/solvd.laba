package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.enums.DocumentStatus;
import com.solvd.laba.oop.legalOffice.enums.DocumentType;
import com.solvd.laba.oop.legalOffice.exceptions.InvalidDocumentException;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;
import com.solvd.laba.oop.legalOffice.interfaces.Reviewable;
import com.solvd.laba.oop.legalOffice.interfaces.Signable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Date;

public class Document implements Signable, Printable, Reviewable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Application.class);
    private DocumentType documentType;
    private String documentContent;
    private Date creationDate;
    private DocumentStatus documentStatus;

    public Document(DocumentType documentType, String documentContent) {
        this.documentType = documentType;
        this.documentContent = documentContent;
        openReview();
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public DocumentStatus getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(DocumentStatus documentStatus) {
        this.documentStatus = documentStatus;
    }

    @Override
    public void openReview() {
        this.setDocumentStatus(DocumentStatus.DEVELOPMENT);
        this.setCreationDate(new Date());
        System.out.println("Document created and open for review. Status: " + getDocumentStatus());
        System.out.println("----------------------------");
    }

    private void validateDocument() throws InvalidDocumentException {
        if (documentType == null || documentContent == null) {
            throw new InvalidDocumentException("Document type or content is null.");
        }

        if (documentContent.trim().isEmpty()) {
            throw new InvalidDocumentException("Document content is empty.");
        }

        if (documentStatus == DocumentStatus.CLOSED) {
            throw new InvalidDocumentException("Document is closed for review.");
        }
    }

    @Override
    public void sign(Client client) {
        try {
            validateDocument();

            this.setDocumentStatus(DocumentStatus.SIGNED);
            System.out.println("Document signed by " + client.firstName + " " + client.lastName + ". Status: " + getDocumentStatus());
            System.out.println("----------------------------");
        } catch (InvalidDocumentException e) {
            System.out.println();
            LOGGER.error("Invalid document: " + e.getMessage() + "\n");
        }
    }

    public void submitToCourt(Court court) {
        this.setDocumentStatus(DocumentStatus.SUBMITTED);
        System.out.println("Document submitted to court " + court.getEntityName() + ". Status: " + getDocumentStatus());
        System.out.println("----------------------------");
    }

    @Override
    public void closeReview() {
        this.setDocumentStatus(DocumentStatus.CLOSED);
        System.out.println("Document close for review. Status: " + getDocumentStatus());
        System.out.println("----------------------------");
    }

    @Override
    public void printDetails() {
        System.out.println("Document Details:");
        System.out.println("Document type: " + documentType);
        System.out.println("Document content: " + documentContent);
        System.out.println("Creation date: " + creationDate);
        System.out.println("Document status: " + documentStatus);
        System.out.println("----------------------------");
    }
}