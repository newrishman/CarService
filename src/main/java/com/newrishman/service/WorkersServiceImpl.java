package com.newrishman.service;

import com.newrishman.domain.Workers;
import com.newrishman.repository.WorkersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkersServiceImpl implements WorkersService {

    private WorkersRepository repository;

    @Autowired
    public void setRepository(WorkersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Workers getWorkersById(long id) {
        return repository.getOne(id);
    }
}
