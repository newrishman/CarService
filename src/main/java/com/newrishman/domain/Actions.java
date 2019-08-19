package com.newrishman.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "actions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Actions {

    @Id
    @Column(name = "id_Action")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAction;
    @Column(name = "Action")
    private String Action;

    public Actions() {
    }

    public Actions(long idAction, String action) {
        this.idAction = idAction;
        Action = action;
    }

    public long getIdAction() {
        return idAction;
    }

    public void setIdAction(long idAction) {
        this.idAction = idAction;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actions actions = (Actions) o;

        if (idAction != actions.idAction) return false;
        return Action != null ? Action.equals(actions.Action) : actions.Action == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAction ^ (idAction >>> 32));
        result = 31 * result + (Action != null ? Action.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "idAction=" + idAction +
                ", Action='" + Action + '\'' +
                '}';
    }
}
