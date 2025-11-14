package com.example.petportal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "pets")
public class Pet {
    @Id
    private String id;
    private String name;
    private String breed;
    private String species;
    private String age; // can be "3 months" or "2 years"
    private String gender;
    private String status; // Available, Pending, Adopted
    private String imageUrl;
    private String description;
    private Date dateAdded;

    public Pet() {
    }

    public Pet(String id, String name, String breed, String species, String age, String gender, String status,
               String imageUrl, String description, Date dateAdded) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.imageUrl = imageUrl;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
