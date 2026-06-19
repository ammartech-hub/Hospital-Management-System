package com.hospital.management.dao;

import com.hospital.management.database.DatabaseConnection;
import com.hospital.management.model.Billing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    // ==========================
    // Add Bill
    // ==========================
    public boolean addBill(Billing bill) {

        String sql = "INSERT INTO billing(patient_id,amount,payment_status,payment_date) VALUES(?,?,?,?)";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, bill.getPatientId());
            ps.setDouble(2, bill.getAmount());
            ps.setString(3, bill.getPaymentStatus());
            ps.setDate(4, Date.valueOf(bill.getPaymentDate()));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // View All Bills
    // ==========================
    public List<Billing> getAllBills() {

        List<Billing> bills = new ArrayList<>();

        String sql = "SELECT * FROM billing ORDER BY bill_id";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Billing bill = new Billing();

                bill.setBillId(rs.getInt("bill_id"));
                bill.setPatientId(rs.getInt("patient_id"));
                bill.setAmount(rs.getDouble("amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));
                bill.setPaymentDate(rs.getDate("payment_date").toString());

                bills.add(bill);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bills;
    }

    // ==========================
    // Get Bill By ID
    // ==========================
    public Billing getBillById(int id) {

        Billing bill = new Billing();

        String sql = "SELECT * FROM billing WHERE bill_id=?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    bill.setBillId(rs.getInt("bill_id"));
                    bill.setPatientId(rs.getInt("patient_id"));
                    bill.setAmount(rs.getDouble("amount"));
                    bill.setPaymentStatus(rs.getString("payment_status"));
                    bill.setPaymentDate(rs.getDate("payment_date").toString());

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bill;
    }

    // ==========================
    // Update Bill
    // ==========================
    public boolean updateBill(Billing bill) {

        String sql = "UPDATE billing SET patient_id=?, amount=?, payment_status=?, payment_date=? WHERE bill_id=?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, bill.getPatientId());
            ps.setDouble(2, bill.getAmount());
            ps.setString(3, bill.getPaymentStatus());
            ps.setDate(4, Date.valueOf(bill.getPaymentDate()));
            ps.setInt(5, bill.getBillId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // Delete Bill
    // ==========================
    public boolean deleteBill(int id) {

        String sql = "DELETE FROM billing WHERE bill_id=?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // Dashboard Revenue
    // ==========================
    public double getTotalRevenue() {

        String sql = "SELECT COALESCE(SUM(amount),0) FROM billing";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // ==========================
    // Dashboard Bill Count
    // ==========================
    public int getBillCount() {

        String sql = "SELECT COUNT(*) FROM billing";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}