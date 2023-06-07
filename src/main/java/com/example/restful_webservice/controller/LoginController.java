package com.example.restful_webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restful_webservice.model.User;
import com.example.restful_webservice.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String ShowLogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        // Perform validation and authentication logic
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            session.setAttribute("username", username);
            return "redirect:/home"; // Redirect to the dashboard page after successful login
        } else {
            // Invalid credentials
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Return the login template or view name with an error message
        }
    }
}
