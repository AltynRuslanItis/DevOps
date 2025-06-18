package ru.itis.springdemo_oris.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String getSingInPage() {
        return "sign_in_page";
    }
}
