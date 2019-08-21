package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "User_Input")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserInput {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name")
    private String First_Name;

    @Column(name = "Last_Name")
    private String Last_Name;

    @Column(name = "Car_Model")
    private String Car_Model;

    @Column(name = "action")
    private String action;

    @Column(name = "date")
    private String date;

    public UserInput(long id, String first_Name, String last_Name, String car_Model, String action, String date) {
        this.id = id;
        First_Name = first_Name;
        Last_Name = last_Name;
        Car_Model = car_Model;
        this.action = action;
        this.date = date;
    }

    public UserInput(String first_Name, String last_Name, String car_Model, String action, String date) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Car_Model = car_Model;
        this.action = action;
        this.date = date;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getCar_Model() {
        return Car_Model;
    }

    public void setCar_Model(String car_Model) {
        Car_Model = car_Model;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
