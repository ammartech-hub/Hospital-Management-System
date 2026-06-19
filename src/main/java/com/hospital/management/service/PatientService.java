package com.hospital.management.service;

import com.hospital.management.dao.PatientDAO;
import com.hospital.management.model.Patient;
import java.util.List;

public class PatientService {

    private final PatientDAO patientDAO = new PatientDAO();

    public boolean addPatient(Patient patient) {
        return patientDAO.addPatient(patient);
    }



    public boolean updatePatient(Patient patient) {
        return patientDAO.updatePatient(patient);
    }

    public boolean deletePatient(int id) {
        return patientDAO.deletePatient(id);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    public Patient getPatientById(int id) {
        return patientDAO.getPatientById(id);
    }

    public int getPatientCount() {
        return patientDAO.getPatientCount();
    }

    public List<Patient> searchPatients(String query) {
        return patientDAO.searchPatients(query);
    }
}

