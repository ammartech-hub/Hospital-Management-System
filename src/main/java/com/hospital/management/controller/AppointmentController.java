package com.hospital.management.controller;

import com.hospital.management.model.Appointment;
import com.hospital.management.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    private AppointmentService appointmentService = new AppointmentService();

    // ==========================
    // View All Appointments
    // ==========================
    @GetMapping("/appointments")
    public String appointments(Model model){

        model.addAttribute("appointments",
                appointmentService.getAllAppointments());

        return "appointments";

    }

    // ==========================
    // Open Add Appointment Page
    // ==========================
    @GetMapping("/addAppointment")
    public String addAppointmentPage(){

        return "addAppointment";

    }

    // ==========================
    // Save Appointment
    // ==========================
    @PostMapping("/saveAppointment")
    public String saveAppointment(

            @RequestParam int patientId,
            @RequestParam int doctorId,
            @RequestParam String appointmentDate,
            @RequestParam String appointmentTime,
            @RequestParam String status){

        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setStatus(status);

        appointmentService.addAppointment(appointment);

        return "redirect:/appointments";

    }

    // ==========================
    // Edit Appointment
    // ==========================
    @GetMapping("/editAppointment/{id}")
    public String editAppointment(@PathVariable int id,
                                  Model model){

        model.addAttribute("appointment",
                appointmentService.getAppointmentById(id));

        return "editAppointment";

    }

    // ==========================
    // Update Appointment
    // ==========================
    @PostMapping("/updateAppointment")
    public String updateAppointment(

            @RequestParam int appointmentId,
            @RequestParam int patientId,
            @RequestParam int doctorId,
            @RequestParam String appointmentDate,
            @RequestParam String appointmentTime,
            @RequestParam String status){

        Appointment appointment = new Appointment();

        appointment.setAppointmentId(appointmentId);
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setStatus(status);

        appointmentService.updateAppointment(appointment);

        return "redirect:/appointments";

    }

    // ==========================
    // Delete Appointment
    // ==========================
    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable int id){

        appointmentService.deleteAppointment(id);

        return "redirect:/appointments";

    }

}