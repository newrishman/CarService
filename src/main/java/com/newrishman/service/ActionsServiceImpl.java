package com.newrishman.service;

import com.newrishman.domain.Actions;
import com.newrishman.repository.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionsServiceImpl implements ActionsService {

    private ActionsRepository repository;

    @Autowired
    public void setRepository(ActionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Actions getIdByJob(String job) {
        return repository.getIdByJob(job);
    }

    @Override
    public Actions getJobById(long id) {
        return repository.getOne(id);
    }

}