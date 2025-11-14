package com.example.petportal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "applications")
public class AdoptionApplication {
    @Id
    private String id;
    private String petId;
    private String applicantName;
    private String email;
    private String phone;
    private String address;
    private String message; // why they want pet
    private String status; // Submitted, Under Review, Approved, Rejected
    private Date submittedAt;

    public AdoptionApplication() {
    }

    public AdoptionApplication(String id, String petId, String applicantName, String email, String phone,
                               String address, String message, String status, Date submittedAt) {
        this.id = id;
        this.petId = petId;
        this.applicantName = applicantName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.message = message;
        this.status = status;
        this.submittedAt = submittedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }
}
