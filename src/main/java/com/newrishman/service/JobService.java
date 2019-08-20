package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.domain.Job;

import java.util.List;

public interface JobService {
    Job saveJob(Job job);

    Job searchWorkerInTime(long idWorker, String date);

    Long getFreeWorker(List<ActionToWorker> set, String date);

    List<Job> getAllJob();
}
