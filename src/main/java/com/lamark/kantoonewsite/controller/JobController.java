/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.controller;

import com.lamark.kantoonewsite.entity.Job;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lamark.kantoonewsite.service.JobService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivanna
 */
public class JobController
        implements RequestHandler<Job, Job> {

    JobService service = new JobService();
    
    @Override
    public Job handleRequest(Job i, Context cntxt) {
        return service.getJobById(i.getId());
    }


}
