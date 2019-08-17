package com.newrishman.service;

import com.newrishman.domain.Owners;

import java.util.List;

public interface OwnersServ{

    Owners getOwnersById(long id);

    Owners saveOwners(Owners owners);

    void updateOwners(Owners owners);

    void deleteOwners(long id);

    List<Owners> findAll();
}
