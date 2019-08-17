package com.newrishman.repository;

import com.newrishman.domain.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepo extends JpaRepository<Cars, Long> {
}
