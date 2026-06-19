package com.hospital.management.service;

import com.hospital.management.dao.AdminDAO;

public class LoginService {

    AdminDAO adminDAO = new AdminDAO();

    public boolean login(String username, String password) {

        return adminDAO.login(username, password);

    }

}