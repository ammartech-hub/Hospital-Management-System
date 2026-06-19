package com.hospital.management.service;

import com.hospital.management.dao.DoctorDAO;
import com.hospital.management.model.Doctor;

import java.util.List;

public class DoctorService {

    private DoctorDAO doctorDAO = new DoctorDAO();

    // ======================
    // Add Doctor
    // ======================
    public boolean addDoctor(Doctor doctor){

        return doctorDAO.addDoctor(doctor);

    }

    // ======================
    // View All Doctors
    // ======================
    public List<Doctor> getAllDoctors(){

        return doctorDAO.getAllDoctors();

    }

    // ======================
    // Get Doctor By ID
    // ======================
    public Doctor getDoctorById(int id){

        return doctorDAO.getDoctorById(id);

    }

    // ======================
    // Update Doctor
    // ======================
    public boolean updateDoctor(Doctor doctor){

        return doctorDAO.updateDoctor(doctor);

    }

    // ======================
    // Delete Doctor
    // ======================
    public boolean deleteDoctor(int id){

        return doctorDAO.deleteDoctor(id);

    }

    // ======================
    // Dashboard Count
    // ======================
    public int getDoctorCount(){

        return doctorDAO.getDoctorCount();

    }

}