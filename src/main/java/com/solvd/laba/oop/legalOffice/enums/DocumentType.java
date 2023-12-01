package com.solvd.laba.oop.legalOffice.enums;

public enum DocumentType {
    AGREEMENT("Legal agreement between parties", DocumentCategory.LEGAL),
    CONTRACT("Formal written agreement", DocumentCategory.LEGAL),
    LAWSUIT("Legal action initiated in court", DocumentCategory.LEGAL),
    STATEMENT("Formal written expression of facts", DocumentCategory.PERSONAL);

    private final String description;
    private final DocumentCategory category;

    DocumentType(String description, DocumentCategory category) {
        this.description = description;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public DocumentCategory getCategory() {
        return category;
    }
}