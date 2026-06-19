package com.hospital.management.dao;

import com.hospital.management.database.DatabaseConnection;
import com.hospital.management.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // =========================
    // Add Doctor
    // =========================
    public boolean addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors(doctor_name,specialization,phone,email,experience) VALUES(?,?,?,?,?)";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getExperience());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================
    // View All Doctors
    // =========================
    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        String sql = "SELECT * FROM doctors ORDER BY doctor_id";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setDoctorName(rs.getString("doctor_name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setEmail(rs.getString("email"));
                doctor.setExperience(rs.getInt("experience"));

                doctors.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctors;
    }

    // =========================
    // Get Doctor By ID
    // =========================
    public Doctor getDoctorById(int id) {

        Doctor doctor = new Doctor();

        String sql = "SELECT * FROM doctors WHERE doctor_id=?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    doctor.setDoctorId(rs.getInt("doctor_id"));
                    doctor.setDoctorName(rs.getString("doctor_name"));
                    doctor.setSpecialization(rs.getString("specialization"));
                    doctor.setPhone(rs.getString("phone"));
                    doctor.setEmail(rs.getString("email"));
                    doctor.setExperience(rs.getInt("experience"));

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctor;
    }

    // =========================
    // Update Doctor
    // =========================
    public boolean updateDoctor(Doctor doctor) {

        String sql = "UPDATE doctors SET doctor_name=?,specialization=?,phone=?,email=?,experience=? WHERE doctor_id=?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getExperience());
            ps.setInt(6, doctor.getDoctorId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // =========================
    // Delete Doctor
    // =========================
    public boolean deleteDoctor(int id) {

        String sql = "DELETE FROM doctors WHERE doctor_id=?";

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

    // =========================
    // Dashboard Count
    // =========================
    public int getDoctorCount() {

        String sql = "SELECT COUNT(*) FROM doctors";

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