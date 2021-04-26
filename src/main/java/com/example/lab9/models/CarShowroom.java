package com.example.lab9.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "car_showroom")
public class CarShowroom implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "car_showroom_id", unique = true)
    private int id;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;

    @Column(name = "pojemnosc", nullable = false)
    private int pojemnosc;

    @Column(name = "miasto", nullable = false)
    private String miasto;

    @OneToMany(mappedBy = "carShowroom", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "carShowroom", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Rating> ratings = new ArrayList<>();

    public boolean addCar(Vehicle v) {
        if (vehicles.size() < pojemnosc) {
            vehicles.add(v);
            v.setCarShowroom(this);
            return true;
        }
        return false;
    }

    public boolean addRate(Rating r){
        if(r.getOcena() <=5 && r.getOcena()>=0){
            ratings.add(r);
            r.setCarShowroom(this);
            return true;
        }
        return false;
    }

    public CarShowroom(int id, String nazwa, int pojemnosc, String miasto) {
        this.id = id;
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.miasto = miasto;
    }

    public CarShowroom(){};

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
