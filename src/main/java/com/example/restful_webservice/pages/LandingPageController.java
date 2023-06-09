package com.example.restful_webservice.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/")
    public String landingPage(Model model) {
        return "LandingPage";
    }
}
