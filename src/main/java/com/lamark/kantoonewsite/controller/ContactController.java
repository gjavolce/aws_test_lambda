/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lamark.kantoonewsite.entity.Contact;
import com.lamark.kantoonewsite.service.ContactService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ContactController implements RequestHandler<Contact, Contact> {

    ContactService service = new ContactService();

    @Override
    public Contact handleRequest(Contact con, Context cntxt) {

        try {
            service.sendEmailForContact(con);
        } catch (IOException ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Contact();
    }

}
