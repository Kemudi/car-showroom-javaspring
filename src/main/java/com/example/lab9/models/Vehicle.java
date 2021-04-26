package com.example.lab9.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "car")
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", unique = true)
    private int id;

    @Column(name = "marka", nullable = false)
    private String marka;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "pojemnosc_silnika", nullable = false)
    private float pojemnosc_silnika;

    @Column(name = "przebieg", nullable = false)
    private float przebieg;

    @Column(name = "rok_produkcji", nullable = false)
    private int rok_produkcji;

    @Column(name = "cena", nullable = false)
    private float cena;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_showroom_id")
    @JsonBackReference
    private CarShowroom carShowroom;


    public Vehicle(String marka, String model, float pojemnosc_silnika, float przebieg, int rok_produkcji, float cena) {
        //this.id = id;
        this.marka = marka;
        this.model = model;
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.przebieg = przebieg;
        this.rok_produkcji = rok_produkcji;
        this.cena = cena;
    }

    public Vehicle() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPojemnosc_silnika() {
        return pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(float pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }

    public float getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(float przebieg) {
        this.przebieg = przebieg;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public CarShowroom getCarShowroom() {
        return carShowroom;
    }

    public void setCarShowroom(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }
}