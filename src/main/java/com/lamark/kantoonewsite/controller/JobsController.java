/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.controller;

import com.lamark.kantoonewsite.entity.Job;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lamark.kantoonewsite.service.JobService;
import java.util.List;

/**
 *
 * @author user
 */
public class JobsController implements RequestHandler<Job, List<Job>> {

    JobService service = new JobService();
    
    @Override
    public List<Job> handleRequest(Job i, Context cntxt) {
        return this.service.getAllJobsArray();
    }
}
