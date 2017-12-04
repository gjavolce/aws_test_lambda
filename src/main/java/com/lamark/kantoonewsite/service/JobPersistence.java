/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.service;

import java.util.List;
import com.lamark.kantoonewsite.entity.Job;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class JobPersistence {

   
    public  List<Job> jobs = new ArrayList<>();

    public void init() {

        jobs.add(new Job(1, "Web Analyst ", "As a Web Analyst designer at Kickstarter, you’ll have the opportunity to positively impact the lives of creators, backers, and the creative community at large."));
        jobs.add(new Job(2, "Product Designer", "As a product designer at Kickstarter, you’ll have the opportunity to positively impact the lives of creators, backers, and the creative community at large."));
        jobs.add(new Job(3, "Animator", "As Animator at Kickstarter, you’ll have the opportunity to positively impact the lives of creators, backers, and the creative community at large."));
        jobs.add(new Job(4, "iOS Engineer", "As iOS Engineer at Kickstarter, you’ll have the opportunity to positively impact the lives of creators, backers, and the creative community at large."));
        jobs.add(new Job(5, "Android Engineer", "As Android Engineer at Kickstarter, you’ll have the opportunity to positively impact the lives of creators, backers, and the creative community at large."));

    }
    
    public JobPersistence() {
        init();
    }
    
}
