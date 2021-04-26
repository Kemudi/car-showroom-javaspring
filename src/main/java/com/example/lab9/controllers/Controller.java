package com.example.lab9.controllers;

import com.example.lab9.managers.CarShowroomManager;
import com.example.lab9.managers.VehicleManager;
import com.example.lab9.models.CarShowroom;

import com.example.lab9.models.Rating;
import com.example.lab9.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class Controller {

    private CarShowroomManager carShowroomManager;
    private VehicleManager vehicleManager;

    @Autowired
    public Controller(CarShowroomManager carShowroomManager, VehicleManager vehicleManager) {
        this.carShowroomManager = carShowroomManager;
        this.vehicleManager = vehicleManager;
    }

    @PostMapping("/product/{id}")
    public ResponseEntity<Void> addVehicle(@PathVariable int id,@RequestBody Vehicle vehicle){
        try{
            carShowroomManager.saveCarToShowroom(id, vehicle);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> removeVehicleFromShowroom(@PathVariable int id) {
       try{
           vehicleManager.deleteCar(id);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/product/{id}/rating")
    public ResponseEntity<Double> getAvarageRate(@PathVariable int id){
        try{
            double result = carShowroomManager.getRates(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/fulfillment")
    public Iterable<CarShowroom> getAll(){
        return carShowroomManager.findAll();
    }

    @PostMapping("/fulfillment")
    public void addShowroom(@RequestBody CarShowroom carShowroom){
       carShowroomManager.save(carShowroom);

    }

    @DeleteMapping("/fulfillment/{id}")
    public ResponseEntity<Void> removeShowroom(@PathVariable int id) {
        try{
            carShowroomManager.deleteShowroom(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/fulfillment/{id}/products")
    public ResponseEntity<Iterable<Vehicle>> getVehiclesFromShowroom(@PathVariable int id){
        try{
            Iterable<Vehicle> result = carShowroomManager.allInShowroom(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/fulfillment/{id}/fill")
    public ResponseEntity<Double> getPercent(@PathVariable int id){
        try{
            double result = carShowroomManager.getFulfillment(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/rating/{id}")
    public ResponseEntity<Void> addShowroom(@PathVariable int id, @RequestBody Rating rating){
        try{
            carShowroomManager.saveRate(id, rating);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
