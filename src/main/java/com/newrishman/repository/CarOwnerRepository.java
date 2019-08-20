package com.newrishman.repository;

import com.newrishman.domain.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    @Query(value = "select * from Car_Owner where id_Owner = :idOwner", nativeQuery = true)
    CarOwner getCarOwnerByIdOwner(@Param("idOwner") long id);
}