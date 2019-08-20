package com.newrishman.repository;

import com.newrishman.domain.ActionToWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActionToWorkerRepository extends JpaRepository<ActionToWorker, Long> {
    @Query(value = "select * from action_to_worker aw where aw.id_Action = :idAction", nativeQuery = true)
    List<ActionToWorker> getActionToWorkerByidActions(@Param("idAction") long id);
}
