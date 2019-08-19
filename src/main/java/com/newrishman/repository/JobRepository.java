package com.newrishman.repository;

import com.newrishman.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query(value = "SELECT * FROM Job where Job.id_Worker = :idWorker and Job.Date_Time = :dateTime", nativeQuery = true)
    Job searchWorkerInTime(@Param("idWorker") long idWorker, @Param("dateTime") String date);
}
