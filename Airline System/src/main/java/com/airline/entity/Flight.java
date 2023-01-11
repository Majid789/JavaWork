package com.airline.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id", nullable = false)
    private Integer id;

    @Column(name = "departure", length = 45)
    private String departure;

    @Column(name = "arrival", length = 45)
    private String arrival;

    @Column(name = "economy_adult_price", length = 45)
    private String economyAdultPrice;

    @Column(name = "business_adult_price", length = 45)
    private String businessAdultPrice;

    @Column(name = "economy_child_price", length = 45)
    private String economyChildPrice;

    @Column(name = "business_child_price", length = 45)
    private String businessChildPrice;

    @Column(name = "departure_date")
    private Date departureDate;

   // @ManyToOne(optional = false)
    @Column(name = "plane_plane_id", nullable = false)
    private Integer planePlane;

    public Integer getPlanePlane() {
        return planePlane;
    }

    public void setPlanePlane(Integer planePlane) {
        this.planePlane = planePlane;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getBusinessChildPrice() {
        return businessChildPrice;
    }

    public void setBusinessChildPrice(String businessChildPrice) {
        this.businessChildPrice = businessChildPrice;
    }

    public String getEconomyChildPrice() {
        return economyChildPrice;
    }

    public void setEconomyChildPrice(String economyChildPrice) {
        this.economyChildPrice = economyChildPrice;
    }

    public String getBusinessAdultPrice() {
        return businessAdultPrice;
    }

    public void setBusinessAdultPrice(String businessAdultPrice) {
        this.businessAdultPrice = businessAdultPrice;
    }

    public String getEconomyAdultPrice() {
        return economyAdultPrice;
    }

    public void setEconomyAdultPrice(String economyAdultPrice) {
        this.economyAdultPrice = economyAdultPrice;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}