package com.newrishman.service;

import com.newrishman.domain.Cars;

public interface CarsService {
    Cars saveCars(Cars cars);

    Cars getCarsByCarModel(String carModel);
}
