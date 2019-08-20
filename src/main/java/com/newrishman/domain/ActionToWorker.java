package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@IdClass(ActionToWorkerID.class)
@Table(name = "action_to_worker")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ActionToWorker {

    @Id
    @Column(name = "id_Action")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAction;

    @Id
    @Column(name = "id_Worker")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        ActionToWorker worker = (ActionToWorker) o;

        if (idAction != worker.idAction) return false;
        return idWorker == worker.idWorker;
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
}
