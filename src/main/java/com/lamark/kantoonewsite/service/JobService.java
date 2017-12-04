/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.service;

import com.lamark.kantoonewsite.entity.Job;
import java.util.List;

/**
 *
 * @author Ivanna
 */
public class JobService {

    JobPersistence jobPersistence = new JobPersistence();

    public List<Job> getAllJobsArray() {
        return this.jobPersistence.jobs;

    }

    public Job getJobById(int id) {
        for(Job currJob : this.jobPersistence.jobs) {
            if(currJob.getId() == id) {
                return currJob;
            }
        }
        
        return this.jobPersistence.jobs.get(0);
    }
}
