package com.newrishman.service;

import com.newrishman.domain.Cars;
import com.newrishman.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarsServiceImpl implements CarsService {

    private CarsRepository repository;

    @Autowired
    public void setRepository(CarsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cars saveCars(Cars cars) {
        repository.save(cars);
        return cars;
    }

    @Override
    public Cars getCarsByCarModel(String carModel) {
        return repository.getCarsByCarModel(carModel);
    }
}
