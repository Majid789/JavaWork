package com.airline.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @Column(name = "payment_method", length = 45)
    private String paymentMethod;

    @Column(name = "credit_card_number")
    private Integer creditCardNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userflights_userflights_id", nullable = false)
    private Userflight userflightsUserflights;

    public Userflight getUserflightsUserflights() {
        return userflightsUserflights;
    }

    public void setUserflightsUserflights(Userflight userflightsUserflights) {
        this.userflightsUserflights = userflightsUserflights;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Integer creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}