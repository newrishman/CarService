package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Owners")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owners {

    @Id
    @Column(name = "idOwner")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOwner;

    @Column(name = "FirstName")
    private String FirstName;
    @Column(name = "LastName")
    private String LastName;


    public Owners(long idOwner, String firstName, String lastName) {
        this.idOwner = idOwner;
        FirstName = firstName;
        LastName = lastName;
    }

    public Owners() {
    }

    public long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owners owners = (Owners) o;

        if (idOwner != owners.idOwner) return false;
        if (FirstName != null ? !FirstName.equals(owners.FirstName) : owners.FirstName != null) return false;
        return LastName != null ? LastName.equals(owners.LastName) : owners.LastName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idOwner ^ (idOwner >>> 32));
        result = 31 * result + (FirstName != null ? FirstName.hashCode() : 0);
        result = 31 * result + (LastName != null ? LastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "idOwner=" + idOwner +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    @ManyToMany(mappedBy = "owners")
    private Set<Cars> cars;

    public Set<Cars> getCars() {
        return cars;
    }

    public void setCars(Set<Cars> cars) {
        this.cars = cars;
    }
}
