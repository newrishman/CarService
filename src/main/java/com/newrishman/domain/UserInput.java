package com.newrishman.domain;

public class UserInput {

    private String first_name;

    private String last_name;

    private String car_model;

    private String action;

    private String date;

    public UserInput(String first_name, String last_name, String car_model, String action, String date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.car_model = car_model;
        this.action = action;
        this.date = date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
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


    @Override
    public String toString() {
        return "UserInput{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", car_model='" + car_model + '\'' +
                ", action='" + action + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
