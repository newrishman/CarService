package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "car_owner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarOwner {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_Car")
    private long idCar;
    @Column(name = "id_Owner")
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

        if (id != carOwner.id) return false;
        if (idCar != carOwner.idCar) return false;
        return idOwner == carOwner.idOwner;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (int) (idOwner ^ (idOwner >>> 32));
        return result;
    }
}
