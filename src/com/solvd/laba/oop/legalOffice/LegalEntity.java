package com.solvd.laba.oop.legalOffice;

public abstract class LegalEntity {
    private String entityName;
    private String address;

    public LegalEntity(String entityName, String address) {
        this.entityName = entityName;
        this.address = address;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract void printDetails();
}