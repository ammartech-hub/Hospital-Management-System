package com.hospital.management.controller;

import com.hospital.management.service.LoginService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    LoginService loginService = new LoginService();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
public String login(
        @RequestParam String username,
        @RequestParam String password,
        HttpSession session) {

    if(username.equals("admin") && password.equals("admin")) {

        session.setAttribute("adminLoggedIn", true);

        return "redirect:/dashboard";
    }

    return "login";
}
 @GetMapping("/logout")
public String logout(HttpSession session) {

    session.invalidate();

    return "redirect:/";
}
}