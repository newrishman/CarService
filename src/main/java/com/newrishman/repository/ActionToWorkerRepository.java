package com.newrishman.repository;

import com.newrishman.domain.ActionToWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ActionToWorkerRepository extends JpaRepository<ActionToWorker, Long> {
    @Query(value = "select * from action_to_worker where id_Action = :idAction", nativeQuery = true)
    List<ActionToWorker> getActionToWorkerByidActions(@Param("idAction") long id);
}
