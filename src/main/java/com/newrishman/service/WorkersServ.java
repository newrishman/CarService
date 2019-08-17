package com.newrishman.service;

import com.newrishman.domain.Workers;

import java.util.List;

public interface WorkersServ{

    Workers getWorkersById(long id);

    Workers saveWorkers(Workers workers);

    void updateWorkers(Workers workers);

    void deleteWorkers(long id);

    List<Workers> findAll();
}
