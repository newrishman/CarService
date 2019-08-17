package com.newrishman.service;

import com.newrishman.domain.Workers;

import java.util.List;

public interface WorkersServ{

    Workers getWorkersById(long id);

    void deleteWorkers(long id);

    List<Workers> findAll();
}
