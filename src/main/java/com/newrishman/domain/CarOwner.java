package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CarOwner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarOwner {

    @Id
    @Column(name = "idCar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCar;
    @Column(name = "idOwner")
    private long idOwner;


    public CarOwner(long idCar, long idOwner) {
        this.idCar = idCar;
        this.idOwner = idOwner;
    }

    public CarOwner() {
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarOwner carOwner = (CarOwner) o;

        if (idCar != carOwner.idCar) return false;
        return idOwner == carOwner.idOwner;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (int) (idOwner ^ (idOwner >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CarOwner{" +
                "idCar=" + idCar +
                ", idOwner=" + idOwner +
                '}';
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Job", joinColumns = @JoinColumn(name = "idCar"), inverseJoinColumns = @JoinColumn(name = "idAction")
    )
    private Set<ActionToWorker> actionToWorkers;

    public Set<ActionToWorker> getActionToWorkers() {
        return actionToWorkers;
    }

    public void setActionToWorkers(Set<ActionToWorker> actionToWorkers) {
        this.actionToWorkers = actionToWorkers;
    }
}
