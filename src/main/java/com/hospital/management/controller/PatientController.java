package com.hospital.management.controller;

import com.hospital.management.model.Patient;
import com.hospital.management.service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class PatientController {

    private final PatientService patientService = new PatientService();

   @GetMapping("/patients")
public String patients(Model model){

    model.addAttribute("patients", patientService.getAllPatients());

    return "patients";
}

    @GetMapping("/patients/search")
    public String searchPatients(@RequestParam(name = "query", required = false) String query,
                                  Model model,
                                  HttpSession session) {
        requireAuth(session);
        if (query == null || query.isBlank()) {
            model.addAttribute("patients", patientService.getAllPatients());
            model.addAttribute("searchQuery", "");
        } else {
            model.addAttribute("patients", patientService.searchPatients(query.trim()));
            model.addAttribute("searchQuery", query.trim());
        }
        return "patients";
    }

   @GetMapping("/addPatient")
public String addPatientPage(){

    return "addPatient";

}

    @PostMapping("/savePatient")
    public String savePatient(
            @RequestParam String patientName,
            @RequestParam int age,
            @RequestParam String gender,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String disease,
            Model model,
            HttpSession session
    ) {

        if (patientName == null || patientName.isBlank()) {
            model.addAttribute("error", "Patient name is required");
            return "addPatient";
        }
        if (age < 0) {
            model.addAttribute("error", "Age must be a positive number");
            return "addPatient";
        }

        Patient patient = new Patient();
        patient.setPatientName(patientName.trim());
        patient.setAge(age);
        patient.setGender(gender == null ? "" : gender.trim());
        patient.setPhone(phone == null ? "" : phone.trim());
        patient.setAddress(address == null ? "" : address.trim());
        patient.setDisease(disease == null ? "" : disease.trim());

        patientService.addPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable int id, HttpSession session) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @GetMapping("/editPatient/{id}")
    public String editPatient(@PathVariable int id, Model model, HttpSession session) {
        model.addAttribute("patient", patientService.getPatientById(id));
        return "editPatient";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(
            @RequestParam int patientId,
            @RequestParam String patientName,
            @RequestParam int age,
            @RequestParam String gender,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String disease,
            Model model,
            HttpSession session
    ) {
        requireAuth(session);

        if (patientName == null || patientName.isBlank()) {
            model.addAttribute("error", "Patient name is required");
            model.addAttribute("patient", patientService.getPatientById(patientId));
            return "editPatient";
        }
        if (age < 0) {
            model.addAttribute("error", "Age must be a positive number");
            model.addAttribute("patient", patientService.getPatientById(patientId));
            return "editPatient";
        }

        Patient patient = new Patient();
        patient.setPatientId(patientId);
        patient.setPatientName(patientName.trim());
        patient.setAge(age);
        patient.setGender(gender == null ? "" : gender.trim());
        patient.setPhone(phone == null ? "" : phone.trim());
        patient.setAddress(address == null ? "" : address.trim());
        patient.setDisease(disease == null ? "" : disease.trim());

        patientService.updatePatient(patient);
        return "redirect:/patients";
    }

    private void requireAuth(HttpSession session) {
        Object ok = session.getAttribute("adminLoggedIn");
        if (ok == null) throw new RuntimeException("Unauthorized");
    }
}

