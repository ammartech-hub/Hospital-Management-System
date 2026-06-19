package com.hospital.management.dao;

import com.hospital.management.database.DatabaseConnection;
import com.hospital.management.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {



    public boolean addPatient(Patient patient) {
        String sql = "INSERT INTO patients(patient_name, age, gender, phone, address, disease) VALUES(?,?,?,?,?,?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getPatientName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getDisease());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY patient_id";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setPatientName(rs.getString("patient_name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setPhone(rs.getString("phone"));
                patient.setAddress(rs.getString("address"));
                patient.setDisease(rs.getString("disease"));
                list.add(patient);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    /**
     * Search patients by patient_id (if numeric) OR patient_name LIKE query.
     */
    public List<Patient> searchPatients(String query) {
        String q = query == null ? "" : query.trim();
        if (q.isEmpty()) {
            return getAllPatients();
        }

        boolean isNumeric = q.matches("\\d+");
        String sql;

        if (isNumeric) {
            sql = "SELECT * FROM patients WHERE patient_id=? ORDER BY patient_id";
        } else {
            sql = "SELECT * FROM patients WHERE LOWER(patient_name) LIKE LOWER(?) ORDER BY patient_id";
        }

        List<Patient> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (isNumeric) {
                ps.setInt(1, Integer.parseInt(q));
            } else {
                ps.setString(1, "%" + q + "%");
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Patient patient = new Patient();
                    patient.setPatientId(rs.getInt("patient_id"));
                    patient.setPatientName(rs.getString("patient_name"));
                    patient.setAge(rs.getInt("age"));
                    patient.setGender(rs.getString("gender"));
                    patient.setPhone(rs.getString("phone"));
                    patient.setAddress(rs.getString("address"));
                    patient.setDisease(rs.getString("disease"));
                    list.add(patient);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET patient_name=?,age=?,gender=?,phone=?,address=?,disease=? WHERE patient_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getPatientName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getDisease());
            ps.setInt(7, patient.getPatientId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id=?";
        Patient patient = null;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    patient = new Patient();
                    patient.setPatientId(rs.getInt("patient_id"));
                    patient.setPatientName(rs.getString("patient_name"));
                    patient.setAge(rs.getInt("age"));
                    patient.setGender(rs.getString("gender"));
                    patient.setPhone(rs.getString("phone"));
                    patient.setAddress(rs.getString("address"));
                    patient.setDisease(rs.getString("disease"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return patient == null ? new Patient() : patient;
    }

    public int getPatientCount() {
        String sql = "SELECT COUNT(*) FROM patients";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
