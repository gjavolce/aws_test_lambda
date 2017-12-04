/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.entity;

/**
 *
 * @author user
 */
public class Contact {

    private String fullName;
    private String email;
    private String companyName;
    private String message;

    public Contact(String fullName, String email, String companyName, String message) {
        this.fullName = fullName;
        this.email = email;
        this.companyName = companyName;
        this.message = message;
    }

    public Contact() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

}
