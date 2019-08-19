package com.newrishman.service;

import com.newrishman.domain.Cars;

public interface CarsService {
    Cars getCarsByCarModel(String carModel);
    Cars getCarsByIdCar(long id);
}
