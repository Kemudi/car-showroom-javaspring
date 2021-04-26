package com.example.lab9.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rating_id", unique = true)
    private int id;

    @Column(name = "ocena", nullable = false)
    private float ocena;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "opis", nullable = false)
    private String opis;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_showroom_id")
    @JsonBackReference
    private CarShowroom carShowroom;



    public Rating(float ocena, Date data, String opis) {
        this.id = id;
        this.ocena = ocena;
        this.data = data;
        this.opis = opis;
    }

    public Rating(){};

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public float getOcena() {
        return ocena;
    }

    public Date getData() {
        return data;
    }

    public String getOpis() {
        return opis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    public CarShowroom getCarShowroom() {
        return carShowroom;
    }

    public void setCarShowroom(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }
}
