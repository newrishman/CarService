package com.newrishman.repository;

import com.newrishman.domain.Actions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActionsRepository extends JpaRepository<Actions, Long> {
    @Query(value = "select * from Actions where Action = :Action", nativeQuery = true)
    Actions getActionsByJob(@Param("Action") String job);
}