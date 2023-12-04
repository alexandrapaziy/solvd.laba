package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.interfaces.Contactable;
import com.solvd.laba.oop.legalOffice.interfaces.Printable;
import com.solvd.laba.oop.legalOffice.interfaces.SingleParameterFunctionalInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Client extends Person implements Printable, Contactable {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Client.class);
    private static int clientCount;
    private String request;
    private Set<ContactInfo> contactInfo;

    public Client(String firstName, String lastName, int age, String request, Set<ContactInfo> contactInfo) {
        super(firstName, lastName, age);
        this.request = request;
        this.contactInfo = contactInfo;
        clientCount++;
    }

    public Set<String> getEmails() {
        return contactInfo.stream()
                .map(ContactInfo::getEmail)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public Set<String> getPhones() {
        return contactInfo.stream()
                .map(ContactInfo::getPhone)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
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
        LOGGER.info("Client Information:");
        LOGGER.info("Name: " + getFirstName() + " " + getLastName());
        LOGGER.info("Request: " + request);
        LOGGER.info("----------------------------");
    }

    @Override
    public void getContacts() {
        LOGGER.info("Contacts:");
        LOGGER.info("Name: " + getFirstName() + " " + getLastName());
        for (ContactInfo contactInfo : contactInfo) {
            LOGGER.info("Phone: " + contactInfo.getPhone());
            LOGGER.info("Email: " + contactInfo.getEmail());
        }
        LOGGER.info("----------------------------");
    }

    public static final int getClientCount() {
        LOGGER.info("Total client count: " + clientCount);
        LOGGER.info("----------------------------");
        return clientCount;
    }

    public void performActionWithContactInfo(SingleParameterFunctionalInterface<Set<ContactInfo>> action) {
        action.performAction(contactInfo);
    }

    public int getFullNameLength(Function<Client, String> fullNameProvider) {
        String fullName = fullNameProvider.apply(this);
        return fullName.length();
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