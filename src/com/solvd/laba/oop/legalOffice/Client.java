package com.solvd.laba.oop.legalOffice;

import java.util.Objects;

public class Client extends Person implements Printable, Contactable {
    private static int clientCount;
    private String request;
    private ContactInfo contactInfo;

    public Client(String firstName, String lastName, int age, String request, ContactInfo contactInfo) {
        super(firstName, lastName, age);
        this.request = request;
        this.contactInfo = contactInfo;
        clientCount++;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public void printDetails() {
        System.out.println("Client Information:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Request: " + request);
        System.out.println("----------------------------");
    }

    @Override
    public void getContacts() {
        System.out.println("Contacts:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Phone: " + contactInfo.getPhone());
        System.out.println("Email: " + contactInfo.getEmail());
        System.out.println("----------------------------");
    }

    public static final int getClientCount() {
        System.out.println("Total client count: " + clientCount);
        System.out.println("----------------------------");
        return clientCount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "request='" + request + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(request, client.request) && Objects.equals(contactInfo, client.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, contactInfo);
    }
}