package com.newrishman.repository;

import com.newrishman.domain.ActionToWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActionToWorkerRepository extends JpaRepository<ActionToWorker, Long> {
    @Query(value = "select * from ActionToWorker where ActionToWorker.idWorker = :idWorker", nativeQuery = true)
    ActionToWorker getActionToWorkerByidWorker(@Param("idWorker") long id);
}
