package com.example.lab9.dao;

import com.example.lab9.models.CarShowroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarShowroomRepo extends CrudRepository<CarShowroom, Integer> {
}
