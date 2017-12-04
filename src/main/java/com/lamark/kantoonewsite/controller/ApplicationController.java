/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lamark.kantoonewsite.entity.Application;
import com.lamark.kantoonewsite.service.ApplicationService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ApplicationController implements RequestHandler<Application, Application> {

    ApplicationService service = new ApplicationService();

    @Override
    public Application handleRequest(Application app, Context cntxt) {
        try {
            service.sendEmailForContact(app);
        } catch (IOException ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
