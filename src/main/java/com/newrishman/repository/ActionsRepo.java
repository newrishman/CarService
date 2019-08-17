package com.newrishman.repository;

import com.newrishman.domain.Actions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionsRepo extends JpaRepository<Actions, Long> {
}