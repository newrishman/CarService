package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Workers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Workers {

    @Id
    @Column(name = "id_Worker")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idWorker;

    @Column(name = "Worker")
    private String Worker;


    public Workers(long idWorker, String worker) {
        this.idWorker = idWorker;
        Worker = worker;
    }

    public Workers() {
    }

    public long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(long idWorker) {
        this.idWorker = idWorker;
    }

    public String getWorker() {
        return Worker;
    }

    public void setWorker(String worker) {
        Worker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workers workers = (Workers) o;

        if (idWorker != workers.idWorker) return false;
        return Worker != null ? Worker.equals(workers.Worker) : workers.Worker == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idWorker ^ (idWorker >>> 32));
        result = 31 * result + (Worker != null ? Worker.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "idWorker=" + idWorker +
                ", Worker='" + Worker + '\'' +
                '}';
    }
}
