package com.solvd.laba.oop.legalOffice;

import com.solvd.laba.oop.legalOffice.exceptions.InvalidContactInfoException;

public class ContactInfo {
    private String phone;
    private String email;

    public ContactInfo(String phone, String email) throws InvalidContactInfoException {

            validateContactInfo(phone, email);
            this.phone = phone;
            this.email = email;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private static void validateContactInfo(String phone, String email) throws InvalidContactInfoException {
        if (phone == null || phone.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            throw new InvalidContactInfoException("Phone or email is null or empty.");
        }
    }
}