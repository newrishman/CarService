package com.newrishman.repository;

import com.newrishman.domain.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarsRepository extends JpaRepository<Cars, Long> {
    @Query(value = "SELECT * FROM Cars where CarModel = :CarModel", nativeQuery = true)
    Cars getCarsByCarModel(@Param("CarModel") String carModel);
}
