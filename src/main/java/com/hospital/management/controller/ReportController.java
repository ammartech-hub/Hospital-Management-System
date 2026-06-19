package com.hospital.management.controller;

import com.hospital.management.service.PatientService;
import com.hospital.management.service.DoctorService;
import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.BillingService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    PatientService patientService = new PatientService();
    DoctorService doctorService = new DoctorService();
    AppointmentService appointmentService = new AppointmentService();
    BillingService billingService = new BillingService();

    @GetMapping("/reports")
    public String reports(Model model){

        model.addAttribute("patientCount",patientService.getPatientCount());

        model.addAttribute("doctorCount",doctorService.getDoctorCount());

        model.addAttribute("appointmentCount",appointmentService.getAppointmentCount());

        model.addAttribute("revenue",billingService.getTotalRevenue());

        return "reports";
    }

}