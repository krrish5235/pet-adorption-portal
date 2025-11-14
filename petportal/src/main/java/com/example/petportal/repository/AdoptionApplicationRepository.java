package com.example.petportal.repository;

import com.example.petportal.model.AdoptionApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionApplicationRepository extends MongoRepository<AdoptionApplication, String> {
    List<AdoptionApplication> findByPetId(String petId);
}
