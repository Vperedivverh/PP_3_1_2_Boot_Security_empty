package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UsersService;

@Controller
//@RequestMapping("/admin")
public class AdminController {
    private final UsersService usersService;

    public AdminController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/admin")
    public String allUsers(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "users";
    }

    @GetMapping("/create")
    public String createUsersForm(User user) {
        return "create";
    }

    @PostMapping("/create")
    public String saveUser(User user) {
        usersService.saveUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersService.getUserById(id));
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        usersService.updateUser(id, user);
        return "redirect:/admin";
    }
}