package com.example.lab9.dao;

import com.example.lab9.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends CrudRepository<Rating, Integer> {
}
