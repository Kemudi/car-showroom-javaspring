package com.example.lab9.managers;

import com.example.lab9.dao.VehicleRepo;
import com.example.lab9.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleManager {

    private VehicleRepo vRepo;

    @Autowired
    public VehicleManager(VehicleRepo vRepo){
        this.vRepo = vRepo;
    }

    public Iterable<Vehicle> findAll(){
        return vRepo.findAll();
    }

    public void deleteCar(int id){
        vRepo.deleteById(id);
    }




}
