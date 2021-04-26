package com.example.lab9.managers;

import com.example.lab9.dao.CarShowroomRepo;
import com.example.lab9.models.CarShowroom;
import com.example.lab9.models.Rating;
import com.example.lab9.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarShowroomManager {

    private CarShowroomRepo csRepo;

    @Autowired
    public CarShowroomManager(CarShowroomRepo csRepo){
        this.csRepo = csRepo;
    }

    public Iterable<CarShowroom> findAll(){
        return csRepo.findAll();
    }

    public double getRates(int id) throws NoSuchElementException{
        Optional<CarShowroom> csOpt = csRepo.findById(id);
        if(csOpt.isEmpty()){
            throw new NoSuchElementException();
        }
        CarShowroom carShowroom = csOpt.get();
        double suma = 0;
        int ilosc = carShowroom.getRatings().size();
        for (Rating rating : carShowroom.getRatings()) {
            suma += rating.getOcena();
        }

        return suma/ilosc;
    }

    public void saveCarToShowroom(int id, Vehicle vehicle) throws NoSuchElementException{
        Optional<CarShowroom> csOpt = csRepo.findById(id);
        if(csOpt.isEmpty()){
            throw new NoSuchElementException();
        }
        CarShowroom carShowroom = csOpt.get();
        carShowroom.addCar(vehicle);
        csRepo.save(carShowroom);
    }

    public void save(CarShowroom carShowroom) {
        csRepo.save(carShowroom);
    }

    public void deleteShowroom(int id) {
        csRepo.deleteById(id);
    }

    public Iterable<Vehicle> allInShowroom(int id) throws NoSuchElementException {
        Optional<CarShowroom> csOpt = csRepo.findById(id);
        if(csOpt.isEmpty()){
            throw new NoSuchElementException();
        }
        CarShowroom carShowroom = csOpt.get();
        return carShowroom.getVehicles();
    }

    public void saveRate(int id, Rating rating) throws NoSuchElementException {
        Optional<CarShowroom> csOpt = csRepo.findById(id);
        if(csOpt.isEmpty()){
            throw new NoSuchElementException();
        }
        CarShowroom carShowroom = csOpt.get();
        carShowroom.addRate(rating);
        csRepo.save(carShowroom);
    }

    public double getFulfillment(int id) throws NoSuchElementException {
        Optional<CarShowroom> csOpt = csRepo.findById(id);
        if(csOpt.isEmpty()){
            throw new NoSuchElementException();
        }
        CarShowroom carShowroom = csOpt.get();
        return ((double)carShowroom.getVehicles().size()/carShowroom.getPojemnosc()) * 100;

    }


}
