package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.domain.Job;

import java.util.List;
import java.util.Set;

public interface JobService {
    Job saveJob(Job job);

    Job searchWorkerInTime(long idWorker, String date);

    Long getFreeWorker(Set<ActionToWorker> set, String date);

    List<Job> getAllJob();
}
