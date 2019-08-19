package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "actions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Actions {

    @Id
    @Column(name = "idAction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAction;
    @Column(name = "Job")
    private String Job;


    public long getIdAction() {
        return idAction;
    }

    public void setIdAction(long idAction) {
        this.idAction = idAction;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public Actions(long idAction, String job) {
        this.idAction = idAction;
        Job = job;
    }

    public Actions() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actions actions = (Actions) o;

        if (idAction != actions.idAction) return false;
        return Job != null ? Job.equals(actions.Job) : actions.Job == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAction ^ (idAction >>> 32));
        result = 31 * result + (Job != null ? Job.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return Job + " " + idAction;
    }

}
