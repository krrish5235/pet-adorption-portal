package com.example.petportal.service;

import com.example.petportal.model.Pet;
import com.example.petportal.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository repo;

    public PetService(PetRepository repo) {
        this.repo = repo;
    }

    public List<Pet> listAll() {
        return repo.findAll();
    }

    public List<Pet> listAvailable() {
        return repo.findByStatus("Available");
    }

    public Optional<Pet> get(String id) {
        return repo.findById(id);
    }

    public Pet save(Pet pet) {
        if (pet.getDateAdded() == null) pet.setDateAdded(new Date());
        if (pet.getStatus() == null) pet.setStatus("Available");
        return repo.save(pet);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
