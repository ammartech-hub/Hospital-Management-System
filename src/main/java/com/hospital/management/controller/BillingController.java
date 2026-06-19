package com.hospital.management.controller;

import com.hospital.management.model.Billing;
import com.hospital.management.service.BillingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BillingController {

    private BillingService billingService = new BillingService();

    // ==========================
    // View Bills
    // ==========================
    @GetMapping("/billing")
    public String billing(Model model){

        model.addAttribute("bills", billingService.getAllBills());

        return "billing";

    }

    // ==========================
    // Add Bill Page
    // ==========================
    @GetMapping("/addBill")
    public String addBillPage(){

        return "addBill";

    }

    // ==========================
    // Save Bill
    // ==========================
    @PostMapping("/saveBill")
    public String saveBill(

            @RequestParam int patientId,
            @RequestParam double amount,
            @RequestParam String paymentStatus,
            @RequestParam String paymentDate){

        Billing bill = new Billing();

        bill.setPatientId(patientId);
        bill.setAmount(amount);
        bill.setPaymentStatus(paymentStatus);
        bill.setPaymentDate(paymentDate);

        billingService.addBill(bill);

        return "redirect:/billing";

    }

    // ==========================
    // Edit Bill
    // ==========================
    @GetMapping("/editBill/{id}")
    public String editBill(@PathVariable int id,
                           Model model){

        model.addAttribute("bill",
                billingService.getBillById(id));

        return "editBill";

    }

    // ==========================
    // Update Bill
    // ==========================
    @PostMapping("/updateBill")
    public String updateBill(

            @RequestParam int billId,
            @RequestParam int patientId,
            @RequestParam double amount,
            @RequestParam String paymentStatus,
            @RequestParam String paymentDate){

        Billing bill = new Billing();

        bill.setBillId(billId);
        bill.setPatientId(patientId);
        bill.setAmount(amount);
        bill.setPaymentStatus(paymentStatus);
        bill.setPaymentDate(paymentDate);

        billingService.updateBill(bill);

        return "redirect:/billing";

    }

    // ==========================
    // Delete Bill
    // ==========================
    @GetMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable int id){

        billingService.deleteBill(id);

        return "redirect:/billing";

    }

}