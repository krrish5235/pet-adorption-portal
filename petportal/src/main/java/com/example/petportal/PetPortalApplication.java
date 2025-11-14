package com.example.petportal;

import com.example.petportal.model.Pet;
import com.example.petportal.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetPortalApplication.class, args);
    }

    // sample data
    @Bean
    CommandLineRunner initData(PetRepository petRepository) {
        return args -> {
            if (petRepository.count() == 0) {
                petRepository.save(new Pet(null, "Buddy", "Golden Retriever", "Dog", "2 years", "Male", "Available",
                        "https://via.placeholder.com/300?text=Buddy", "Friendly, loves walks", null));

                petRepository.save(new Pet(null, "Mittens", "Indian Shorthair", "Cat", "1 year", "Female", "Available",
                        "https://via.placeholder.com/300?text=Mittens", "Loves laps and toys", null));
            }
        };
    }
}
