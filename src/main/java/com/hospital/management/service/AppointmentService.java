package com.hospital.management.service;

import com.hospital.management.dao.AppointmentDAO;
import com.hospital.management.model.Appointment;

import java.util.List;

public class AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    public boolean addAppointment(Appointment appointment){

        return appointmentDAO.addAppointment(appointment);

    }

    public List<Appointment> getAllAppointments(){

        return appointmentDAO.getAllAppointments();

    }

    public Appointment getAppointmentById(int id){

        return appointmentDAO.getAppointmentById(id);

    }

    public boolean updateAppointment(Appointment appointment){

        return appointmentDAO.updateAppointment(appointment);

    }

    public boolean deleteAppointment(int id){

        return appointmentDAO.deleteAppointment(id);

    }

    public int getAppointmentCount(){

        return appointmentDAO.getAppointmentCount();

    }

}