package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ActionToWorker")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ActionToWorker {

    @Id
    @Column(name = "idAction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAction;
    @Column(name = "idWorker")
    private long idWorker;


    public long getIdAction() {
        return idAction;
    }

    public void setIdAction(long idAction) {
        this.idAction = idAction;
    }

    public long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(long idWorker) {
        this.idWorker = idWorker;
    }

    public ActionToWorker(long idAction, long idWorker) {
        this.idAction = idAction;
        this.idWorker = idWorker;
    }

    public ActionToWorker() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionToWorker that = (ActionToWorker) o;

        if (idAction != that.idAction) return false;
        return idWorker == that.idWorker;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAction ^ (idAction >>> 32));
        result = 31 * result + (int) (idWorker ^ (idWorker >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ActionToWorker{" +
                "idAction=" + idAction +
                ", idWorker=" + idWorker +
                '}';
    }

    @ManyToMany(mappedBy = "actionToWorkers")
    private Set<CarOwner> carOwners;

    public Set<CarOwner> getCarOwners() {
        return carOwners;
    }

    public void setCarOwners(Set<CarOwner> carOwners) {
        this.carOwners = carOwners;
    }
}
