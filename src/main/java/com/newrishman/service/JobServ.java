package com.newrishman.service;

import com.newrishman.domain.Job;

import java.util.List;

public interface JobServ{

    Job getJobById(long id);

    Job saveJob(Job job);

    void updateJob(Job job);

    void deleteJob(long id);

    List<Job> findAll();
}
