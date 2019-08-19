package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Job")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Job {

    @Id
    @Column(name = "idAction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAction;
    @Column(name = "idCar")
    private long idCar;
    @Column(name = "idWorker")
    private long idWorker;
    @Column(name = "DateTime")
    private String DateTime;

    public Job(long idAction, long idCar, long idWorker, String dateTime) {
        this.idAction = idAction;
        this.idCar = idCar;
        this.idWorker = idWorker;
        DateTime = dateTime;
    }

    public Job() {
    }

    public long getIdAction() {
        return idAction;
    }

    public void setIdAction(long idAction) {
        this.idAction = idAction;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(long idWorker) {
        this.idWorker = idWorker;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (idAction != job.idAction) return false;
        if (idCar != job.idCar) return false;
        if (idWorker != job.idWorker) return false;
        return DateTime != null ? DateTime.equals(job.DateTime) : job.DateTime == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAction ^ (idAction >>> 32));
        result = 31 * result + (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (int) (idWorker ^ (idWorker >>> 32));
        result = 31 * result + (DateTime != null ? DateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "idAction=" + idAction +
                ", idCar=" + idCar +
                ", idWorker=" + idWorker +
                ", DateTime='" + DateTime + '\'' +
                '}';
    }
}
