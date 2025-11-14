package com.example.petportal.service;

import com.example.petportal.model.AdoptionApplication;
import com.example.petportal.repository.AdoptionApplicationRepository;
import com.example.petportal.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdoptionApplicationService {
    private final AdoptionApplicationRepository appRepo;
    private final PetRepository petRepo;

    public AdoptionApplicationService(AdoptionApplicationRepository appRepo, PetRepository petRepo) {
        this.appRepo = appRepo;
        this.petRepo = petRepo;
    }

    public AdoptionApplication submit(AdoptionApplication a) {
        a.setStatus("Submitted");
        a.setSubmittedAt(new Date());
        AdoptionApplication saved = appRepo.save(a);
        // optionally set pet status to Pending
        petRepo.findById(a.getPetId()).ifPresent(p -> {
            p.setStatus("Pending Adoption");
            petRepo.save(p);
        });
        return saved;
    }

    public List<AdoptionApplication> listAll() {
        return appRepo.findAll();
    }

    public Optional<AdoptionApplication> get(String id) {
        return appRepo.findById(id);
    }

    public List<AdoptionApplication> findByPet(String petId) {
        return appRepo.findByPetId(petId);
    }

    public AdoptionApplication updateStatus(String id, String status) {
        Optional<AdoptionApplication> oa = appRepo.findById(id);
        if (oa.isPresent()) {
            AdoptionApplication a = oa.get();
            a.setStatus(status);
            AdoptionApplication saved = appRepo.save(a);
            // if approved, mark pet Adopted; if rejected, mark Available
            petRepo.findById(a.getPetId()).ifPresent(p -> {
                if ("Approved".equalsIgnoreCase(status)) p.setStatus("Adopted");
                else if ("Rejected".equalsIgnoreCase(status)) p.setStatus("Available");
                else p.setStatus("Pending Adoption");
                petRepo.save(p);
            });
            return saved;
        }
        return null;
    }
}
