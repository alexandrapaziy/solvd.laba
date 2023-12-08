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

public class Document extends Thread implements Signable, Printable, Reviewable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Document.class);
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
        LOGGER.info("Document created and open for review. Status: " + getDocumentStatus());
        LOGGER.info("----------------------------");
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
            LOGGER.info("Document signed by " + client.firstName + " " + client.lastName + ". Status: " + getDocumentStatus());
            LOGGER.info("----------------------------");
        } catch (InvalidDocumentException e) {
            LOGGER.error("Invalid document: " + e.getMessage() + "\n");
        }
    }

    public void submitToCourt(Court court) {
        this.setDocumentStatus(DocumentStatus.SUBMITTED);
        LOGGER.info("Document submitted to court " + court.getEntityName() + ". Status: " + getDocumentStatus());
        LOGGER.info("----------------------------");
    }

    @Override
    public void closeReview() {
        this.setDocumentStatus(DocumentStatus.CLOSED);
        LOGGER.info("Document close for review. Status: " + getDocumentStatus());
        LOGGER.info("----------------------------");
    }

    @Override
    public void printDetails() {
        LOGGER.info("Document Details:");
        LOGGER.info("Document type: " + documentType);
        LOGGER.info("Document content: " + documentContent);
        LOGGER.info("Creation date: " + creationDate);
        LOGGER.info("Document status: " + documentStatus);
        LOGGER.info("----------------------------");
    }

    @Override
    public void run() {
        LOGGER.info("Thread is running...");
    }
}