package com.newrishman.repository;

import com.newrishman.domain.Workers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkersRepository extends JpaRepository<Workers, Long> {
}
