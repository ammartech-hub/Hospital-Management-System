package com.hospital.management.controller;

import com.hospital.management.model.Doctor;
import com.hospital.management.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorController {

    private DoctorService doctorService = new DoctorService();

    // =========================
    // View All Doctors
    // =========================
    @GetMapping("/doctors")
    public String doctors(Model model) {

        model.addAttribute("doctors", doctorService.getAllDoctors());

        return "doctors";
    }

    // =========================
    // Open Add Doctor Page
    // =========================
    @GetMapping("/addDoctor")
    public String addDoctorPage() {

        return "addDoctor";
    }

    // =========================
    // Save Doctor
    // =========================
    @PostMapping("/saveDoctor")
    public String saveDoctor(
            @RequestParam String doctorName,
            @RequestParam String specialization,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam int experience) {

        Doctor doctor = new Doctor();

        doctor.setDoctorName(doctorName);
        doctor.setSpecialization(specialization);
        doctor.setPhone(phone);
        doctor.setEmail(email);
        doctor.setExperience(experience);

        doctorService.addDoctor(doctor);

        return "redirect:/doctors";
    }

    // =========================
    // Edit Doctor
    // =========================
    @GetMapping("/editDoctor/{id}")
    public String editDoctor(@PathVariable int id, Model model) {

        Doctor doctor = doctorService.getDoctorById(id);

        model.addAttribute("doctor", doctor);

        return "editDoctor";
    }

    // =========================
    // Update Doctor
    // =========================
    @PostMapping("/updateDoctor")
    public String updateDoctor(
            @RequestParam int doctorId,
            @RequestParam String doctorName,
            @RequestParam String specialization,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam int experience) {

        Doctor doctor = new Doctor();

        doctor.setDoctorId(doctorId);
        doctor.setDoctorName(doctorName);
        doctor.setSpecialization(specialization);
        doctor.setPhone(phone);
        doctor.setEmail(email);
        doctor.setExperience(experience);

        doctorService.updateDoctor(doctor);

        return "redirect:/doctors";
    }

    // =========================
    // Delete Doctor
    // =========================
    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable int id) {

        doctorService.deleteDoctor(id);

        return "redirect:/doctors";
    }

}