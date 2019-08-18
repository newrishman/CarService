package com.newrishman.service;

import com.newrishman.domain.Owners;

public interface OwnersService {
    Owners saveOwner(Owners owners);

    Owners getOwnerById(long id);

    Owners getOwnerByFirstAndLastName(String firstName, String lastName);
}
