package ru.itis.springdemo_oris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springdemo_oris.services.UsersServices;

@Controller
public class UsersController {

    @Autowired
    private UsersServices usersServices;

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("usersList", usersServices.getAllUsers());
        return "users_page";
    }
}
