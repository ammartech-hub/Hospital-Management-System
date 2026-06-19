package com.hospital.management.controller;

import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.BillingService;
import com.hospital.management.service.DoctorService;
import com.hospital.management.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();
    private AppointmentService appointmentService = new AppointmentService();
    private BillingService billingService = new BillingService();

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("patientCount",
                patientService.getPatientCount());

        model.addAttribute("doctorCount",
                doctorService.getDoctorCount());

        model.addAttribute("appointmentCount",
                appointmentService.getAppointmentCount());

        model.addAttribute("revenue",
                billingService.getTotalRevenue());

        return "dashboard";
    }

}