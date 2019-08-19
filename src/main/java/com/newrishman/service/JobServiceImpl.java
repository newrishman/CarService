package com.newrishman.service;

import com.newrishman.domain.Job;
import com.newrishman.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JobServiceImpl implements JobService {

    private JobRepository repository;

    @Autowired
    public void setRepository(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public Job saveJob(Job job) {
        repository.saveAndFlush(job);
        return job;
    }
}
