package com.hospital.management.service;

import com.hospital.management.dao.BillingDAO;
import com.hospital.management.model.Billing;

import java.util.List;

public class BillingService {

    private BillingDAO billingDAO = new BillingDAO();

    // Add Bill
    public boolean addBill(Billing bill){

        return billingDAO.addBill(bill);

    }

    // View All Bills
    public List<Billing> getAllBills(){

        return billingDAO.getAllBills();

    }

    // Get Bill By ID
    public Billing getBillById(int id){

        return billingDAO.getBillById(id);

    }

    // Update Bill
    public boolean updateBill(Billing bill){

        return billingDAO.updateBill(bill);

    }

    // Delete Bill
    public boolean deleteBill(int id){

        return billingDAO.deleteBill(id);

    }

    // Dashboard Revenue
    public double getTotalRevenue(){

        return billingDAO.getTotalRevenue();

    }

    // Dashboard Bill Count
    public int getBillCount(){

        return billingDAO.getBillCount();

    }

}