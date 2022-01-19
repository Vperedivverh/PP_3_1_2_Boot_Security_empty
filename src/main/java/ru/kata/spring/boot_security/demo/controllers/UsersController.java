package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UsersServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {
    private  final UsersServiceImpl usersService;

    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }


    @GetMapping()

    public String user(ModelMap model, Principal principal) {
        User user = usersService.getUserByName(principal.getName());
        model.addAttribute("user", user);
        System.out.println(user);
        System.out.println(principal.getName());
        return "user";
    }
    }

