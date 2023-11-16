package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.interfaces.Contactable;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;

import java.util.Objects;
import java.util.Set;

public class Client extends Person implements Printable, Contactable {
    private static int clientCount;
    private String request;
    private Set<ContactInfo> contactInfo;

    public Client(String firstName, String lastName, int age, String request, Set<ContactInfo> contactInfo) {
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

    public Set<ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Set<ContactInfo> contactInfo) {
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
        for (ContactInfo contactInfo : contactInfo) {
            System.out.println("Phone: " + contactInfo.getPhone());
            System.out.println("Email: " + contactInfo.getEmail());
        }
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