package com.example.javafxassignemnt.entity;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name = "state_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", length = 45)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_country_id", nullable = false)
    private Country countryCountry;

    public Country getCountryCountry() {
        return countryCountry;
    }

    public void setCountryCountry(Country countryCountry) {
        this.countryCountry = countryCountry;
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