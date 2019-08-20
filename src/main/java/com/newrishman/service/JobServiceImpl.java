package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.domain.Job;
import com.newrishman.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Service
public class JobServiceImpl implements JobService {
    private BlockingQueue<Long> list;
    private JobRepository repository;

    @Autowired
    public void setRepository(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public Job saveJob(Job job) {
        repository.saveAndFlush(job);
        return job;
    }

    @Override
    public Job searchWorkerInTime(long idWorker, String date) {
        return repository.searchWorkerInTime(idWorker, date);
    }

    @Override
    public Long getFreeWorker(Set<ActionToWorker> set, String date) {

        // постановка рабочих в очередь по их ID
        list = new ArrayBlockingQueue<>(10);
        for (ActionToWorker worker : set) {
            try {
                list.put(worker.getIdWorker());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Проверка занятости работника в БД
        Job job = new Job();
        int size = list.size();
        for (int x = 0; x < size; x++) {
            long id = list.poll();
            job = searchWorkerInTime(id, date);
            if (searchWorkerInTime(id, date).getIdWorker() != 0) {
                return id;
            }
        }
        return null;
    }

    @Override
    public List<Job> getAllJob() {
        return repository.findAll();
    }
}
