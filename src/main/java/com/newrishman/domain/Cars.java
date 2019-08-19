package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cars {

    @Id
    @Column(name = "id_Car")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCar;

    @Column(name = "Car_Model")
    private String CarModel;


    public Cars(long idCar, String carModel) {
        this.idCar = idCar;
        CarModel = carModel;
    }

    public Cars() {
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        CarModel = carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars = (Cars) o;

        if (idCar != cars.idCar) return false;
        return CarModel != null ? CarModel.equals(cars.CarModel) : cars.CarModel == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (CarModel != null ? CarModel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "idCar=" + idCar +
                ", CarModel='" + CarModel + '\'' +
                '}';
    }

   /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "CarOwner", joinColumns = @JoinColumn(name = "idCar"), inverseJoinColumns = @JoinColumn(name = "idOwner")
    )
    private Set<Owners> owners;

    public Set<Owners> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owners> owners) {
        this.owners = owners;
    }*/
}
