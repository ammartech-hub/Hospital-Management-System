package com.hospital.management.dao;

import com.hospital.management.database.DatabaseConnection;
import com.hospital.management.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    // ==========================
    // Add Appointment
    // ==========================
    public boolean addAppointment(Appointment appointment){

        String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES(?,?,?,?,?)";

        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, Date.valueOf(appointment.getAppointmentDate()));
            String time = appointment.getAppointmentTime();

            if (time.length() == 5) {
            time = time + ":00";
}

ps.setTime(4, Time.valueOf(time));
            ps.setString(5, appointment.getStatus());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    // ==========================
    // View All Appointments
    // ==========================
    public List<Appointment> getAllAppointments(){

        List<Appointment> list = new ArrayList<>();

        String sql = "SELECT * FROM appointments ORDER BY appointment_id";

        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){

            while(rs.next()){

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getDate("appointment_date").toString());
                appointment.setAppointmentTime(rs.getTime("appointment_time").toString());
                appointment.setStatus(rs.getString("status"));

                list.add(appointment);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }

    // ==========================
    // Get Appointment By ID
    // ==========================
    public Appointment getAppointmentById(int id){

        Appointment appointment = new Appointment();

        String sql = "SELECT * FROM appointments WHERE appointment_id=?";

        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getDate("appointment_date").toString());
                appointment.setAppointmentTime(rs.getTime("appointment_time").toString());
                appointment.setStatus(rs.getString("status"));

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return appointment;

    }

    // ==========================
    // Update Appointment
    // ==========================
    public boolean updateAppointment(Appointment appointment){

        String sql = "UPDATE appointments SET patient_id=?,doctor_id=?,appointment_date=?,appointment_time=?,status=? WHERE appointment_id=?";

        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){

            ps.setInt(1,appointment.getPatientId());
            ps.setInt(2,appointment.getDoctorId());
            ps.setDate(3,Date.valueOf(appointment.getAppointmentDate()));
            ps.setTime(4,Time.valueOf(appointment.getAppointmentTime()));
            ps.setString(5,appointment.getStatus());
            ps.setInt(6,appointment.getAppointmentId());

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    // ==========================
    // Delete Appointment
    // ==========================
    public boolean deleteAppointment(int id){

        String sql = "DELETE FROM appointments WHERE appointment_id=?";

        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){

            ps.setInt(1,id);

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    // ==========================
    // Dashboard Count
    // ==========================
    public int getAppointmentCount(){

        String sql = "SELECT COUNT(*) FROM appointments";

        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){

            if(rs.next()){

                return rs.getInt(1);

            }

        }catch(Exception e){

            System.out.println("Appointment Save Error:");
            e.printStackTrace();

        }

        return 0;

    }

}