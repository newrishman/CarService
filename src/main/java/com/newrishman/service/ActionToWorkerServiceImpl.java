package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.repository.ActionToWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionToWorkerServiceImpl implements ActionToWorkerService {

    private ActionToWorkerRepository repository;

    @Autowired
    public void setRepository(ActionToWorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActionToWorker getActionToWorkerByidAction(long id) {
        return repository.getOne(id);
    }

    @Override
    public ActionToWorker getActionToWorkerByidWorker(long id) {
        return repository.getActionToWorkerByidWorker(id);
    }
}
