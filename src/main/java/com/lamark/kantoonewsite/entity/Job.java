/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.entity;

/**
 *
 * @author Ivanna
 */
public class Job {
    private int id;
    private String jobTitle;
    private String jobDescription;

    public Job(int id, String jobTitle, String jobDescription) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    public Job() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    
}
