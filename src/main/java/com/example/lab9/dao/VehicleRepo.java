package com.example.lab9.dao;

import com.example.lab9.models.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends CrudRepository<Vehicle, Integer> {
}
