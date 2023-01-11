package com.airline.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userflights")
public class Userflight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userflights_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flight_flight_id", nullable = false)
    private Flight flightFlight;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

    public User getUserUser() {
        return userUser;
    }

    public void setUserUser(User userUser) {
        this.userUser = userUser;
    }

    public Flight getFlightFlight() {
        return flightFlight;
    }

    public void setFlightFlight(Flight flightFlight) {
        this.flightFlight = flightFlight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}