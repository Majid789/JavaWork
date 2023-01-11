package com.example.javafxassignemnt.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "town")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "description", length = 45)
    private String description;

    @Column(name = "longitude", precision = 10)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 10)
    private BigDecimal latitude;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_city_id", nullable = false)
    private City cityCity;

    public City getCityCity() {
        return cityCity;
    }

    public void setCityCity(City cityCity) {
        this.cityCity = cityCity;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
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