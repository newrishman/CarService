package com.newrishman.repository;

import com.newrishman.domain.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepo extends JpaRepository<CarOwner, Long> {
}
