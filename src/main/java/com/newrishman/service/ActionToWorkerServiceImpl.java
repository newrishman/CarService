package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.repository.ActionToWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ActionToWorkerServiceImpl implements ActionToWorkerService {

    private ActionToWorkerRepository repository;

    @Autowired
    public void setRepository(ActionToWorkerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Set<ActionToWorker> getActionToWorkerByidActions(long id) {
        return repository.getActionToWorkerByidActions(id);
    }
}
