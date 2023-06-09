package com.example.restful_webservice.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.restful_webservice.user.User;
import com.example.restful_webservice.user.UserService;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute("user") User user, Model model) {
        User existingUser = userService.getUser(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("error", "Username already exists. Please choose a different username.");
            return "signup";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
}
