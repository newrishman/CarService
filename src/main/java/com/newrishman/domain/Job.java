package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "job")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Job {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_Actions")
    private long idAction;
    @Column(name = "id_Cars")
    private long idCar;
    @Column(name = "id_Worker")
    private long idWorker;
    @Column(name = "Date_Time")
    private String dateTime;

    public Job(long idAction, long idCar, long idWorker, String dateTime) {
        this.idAction = idAction;
        this.idCar = idCar;
        this.idWorker = idWorker;
        this.dateTime = dateTime;
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
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (id != job.id) return false;
        if (idAction != job.idAction) return false;
        if (idCar != job.idCar) return false;
        if (idWorker != job.idWorker) return false;
        return dateTime != null ? dateTime.equals(job.dateTime) : job.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idAction ^ (idAction >>> 32));
        result = 31 * result + (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (int) (idWorker ^ (idWorker >>> 32));
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "idAction=" + idAction +
                ", idCar=" + idCar +
                ", idWorker=" + idWorker +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
