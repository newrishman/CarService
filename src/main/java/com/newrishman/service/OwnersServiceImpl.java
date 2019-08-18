package com.newrishman.service;

import com.newrishman.domain.Owners;
import com.newrishman.repository.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnersServiceImpl implements OwnersService {

    private OwnersRepository repository;

    @Autowired
    public void setRepository(OwnersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Owners saveOwner(Owners owners) {
        repository.save(owners);
        return owners;
    }

    @Override
    public Owners getOwnerById(long id) {
        return repository.getOne(id);
    }

    @Override
    public Owners getOwnerByFirstAndLastName(String firstName, String lastName) {
        return repository.getOwnerByFirstAndLastName(firstName, lastName);
    }
}
