package com.neoflex.spring.mvc.controllers;

import com.neoflex.spring.mvc.entity.Users;
import com.neoflex.spring.mvc.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user-home")
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;

    @RequestMapping("/allUsers")
    public String showAllUsers(Model model) {
        List<Users> usersList = usersService.getAllUsers();
        model.addAttribute("users", usersList);
        return "showAllUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", usersService.getUser(id));
        return "getUser";
    }

    @RequestMapping("/newUser")
    public String newUsers(Model model) {
        model.addAttribute("user", new Users());
        return "newUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute(value = "user") @Valid Users user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        } else {
            usersService.saveUser(user);
            return "redirect:/user-home/allUsers";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", usersService.getUser(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid Users user, @PathVariable("id") Long id,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        } else {
            usersService.update(id, user);
            return "redirect:/user-home/allUsers";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUser(id);
        return "redirect:/user-home/allUsers";
    }

}
