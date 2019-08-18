package com.newrishman.repository;

import com.newrishman.domain.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnersRepository extends JpaRepository<Owners, Long> {
}
