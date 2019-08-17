package com.newrishman.service;

import com.newrishman.domain.CarOwner;

import java.util.List;

public interface CarOwnerServ{

    CarOwner getCarOwnerById(long id);

    CarOwner saveCarOwner(CarOwner carOwner);

    void updateCarOwner(CarOwner carOwner);

    void deleteCarOwner(long id);

    List<CarOwner> findAll();

}
