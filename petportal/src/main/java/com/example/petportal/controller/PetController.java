package com.example.petportal.controller;

import com.example.petportal.model.AdoptionApplication;
import com.example.petportal.model.Pet;
import com.example.petportal.service.AdoptionApplicationService;
import com.example.petportal.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PetController {
    private final PetService petService;
    private final AdoptionApplicationService appService;

    public PetController(PetService petService, AdoptionApplicationService appService) {
        this.petService = petService;
        this.appService = appService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("available", petService.listAvailable());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "add";
    }

    @PostMapping("/add")
    public String createPet(@ModelAttribute Pet pet, RedirectAttributes ra) {
        petService.save(pet);
        ra.addFlashAttribute("message", "Pet added successfully");
        return "redirect:/pets";
    }

    @GetMapping("/pets")
    public String listPets(Model model) {
        model.addAttribute("pets", petService.listAll());
        return "pets";
    }

    @GetMapping("/pets/{id}")
    public String petDetail(@PathVariable String id, Model model) {
        Optional<Pet> p = petService.get(id);
        if (p.isEmpty()) return "redirect:/pets";
        model.addAttribute("pet", p.get());
        model.addAttribute("applications", appService.findByPet(id));
        return "pet_detail";
    }

    @GetMapping("/apply/{petId}")
    public String applyForm(@PathVariable String petId, Model model) {
        AdoptionApplication a = new AdoptionApplication();
        a.setPetId(petId);
        model.addAttribute("application", a);
        return "apply";
    }

    @PostMapping("/apply")
    public String submitApplication(@ModelAttribute AdoptionApplication application, RedirectAttributes ra) {
        appService.submit(application);
        ra.addFlashAttribute("message", "Application submitted.");
        return "redirect:/pets";
    }

    // admin - list applications
    @GetMapping("/admin/applications")
    public String adminApps(Model model) {
        model.addAttribute("apps", appService.listAll());
        return "apps_admin";
    }

    @PostMapping("/admin/applications/{id}/status")
    public String changeStatus(@PathVariable String id, @RequestParam String status, RedirectAttributes ra) {
        appService.updateStatus(id, status);
        ra.addFlashAttribute("message", "Status updated.");
        return "redirect:/admin/applications";
    }
}
