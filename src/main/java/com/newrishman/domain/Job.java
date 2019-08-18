package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Job")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Job {

    @Id
    @Column(name = "idCar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCar;
    @Column(name = "idAction")
    private long idAction;
    @Column(name = "DateTime")
    private String DateTime;

    public Job(long idAction, long idCar, String dataTime) {
        this.idAction = idAction;
        this.idCar = idCar;
        DateTime = dataTime;
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

    public String getDataTime() {
        return DateTime;
    }

    public void setDataTime(String dataTime) {
        DateTime = dataTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (idAction != job.idAction) return false;
        if (idCar != job.idCar) return false;
        return DateTime != null ? DateTime.equals(job.DateTime) : job.DateTime == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAction ^ (idAction >>> 32));
        result = 31 * result + (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (DateTime != null ? DateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "idAction=" + idAction +
                ", idCar=" + idCar +
                ", DataTime='" + DateTime + '\'' +
                '}';
    }
}
