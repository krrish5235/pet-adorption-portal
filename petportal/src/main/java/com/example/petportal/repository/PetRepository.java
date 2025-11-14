package com.example.petportal.repository;

import com.example.petportal.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
    List<Pet> findByStatus(String status);
}
