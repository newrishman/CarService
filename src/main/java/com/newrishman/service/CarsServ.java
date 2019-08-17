package com.newrishman.service;

import com.newrishman.domain.Cars;

import java.util.List;

public interface CarsServ{

    Cars getCarsById(long id);

    Cars saveCars(Cars cars);

    void updateCars(Cars cars);

    void deleteCars(long id);

    List<Cars> findAll();
}
