package com.newrishman.service;

import com.newrishman.domain.CarOwner;

public interface CarOwnerService {
    CarOwner saveCarOwner(CarOwner carOwner);

    CarOwner getCarOwnerByIdCar(long id);

    CarOwner getCarOwnerByIdOwner(long id);
}
