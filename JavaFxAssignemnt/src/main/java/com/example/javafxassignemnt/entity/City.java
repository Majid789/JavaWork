package com.example.javafxassignemnt.entity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", length = 45)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state_state_id", nullable = false)
    private State stateState;

    public State getStateState() {
        return stateState;
    }

    public void setStateState(State stateState) {
        this.stateState = stateState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}