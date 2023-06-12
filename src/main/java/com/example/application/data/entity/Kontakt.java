package com.example.application.data.entity;

import jakarta.validation.constraints.Email;

public class Kontakt {
    private String message;
    private String phone;
    @Email
    private String email;

    public String getMessage() {
        return message;
    }
    public void setFirstName(String message) {
        this.message = message;
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
}
