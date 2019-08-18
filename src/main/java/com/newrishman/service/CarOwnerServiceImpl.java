package com.newrishman.service;

import com.newrishman.domain.CarOwner;
import com.newrishman.repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {

    private CarOwnerRepository repository;

    @Autowired
    public void setRepository(CarOwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarOwner saveCarOwner(CarOwner carOwner) {
        repository.save(carOwner);
        return carOwner;
    }

    @Override
    public CarOwner getCarOwnerByIdCar(long id) {
        return repository.getOne(id);
    }

    @Override
    public CarOwner getCarOwnerByIdOwner(long id) {
        return repository.getCarOwnerByIdOwner(id);
    }
}
