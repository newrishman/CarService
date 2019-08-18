package com.newrishman.repository;

import com.newrishman.domain.Actions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActionsRepository extends JpaRepository<Actions, Long> {
    @Query(value = "select * from Actions where job = :job", nativeQuery = true)
    Actions getIdByJob(@Param("job") String job);
}