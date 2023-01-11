package com.example.javafxassignemnt.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address", length = 191)
    private String address;

    @Column(name = "lat", length = 191)
    private String lat;

    @Column(name = "lng", length = 191)
    private String lng;

    @Column(name = "apartment", length = 191)
    private String apartment;

    @Column(name = "floor", length = 191)
    private String floor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_town_id", nullable = false)
    private Town townTown;

    @ManyToOne(optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private User users;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Town getTownTown() {
        return townTown;
    }

    public void setTownTown(Town townTown) {
        this.townTown = townTown;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}