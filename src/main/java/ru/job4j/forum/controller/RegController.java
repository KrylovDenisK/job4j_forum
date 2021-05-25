package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;


@Controller
public class RegController {
    private UserService userService;

    public RegController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        String returnAddress;
        if (userService.userVerification(user.getUsername())) {
            userService.createUser(user);
            returnAddress = "redirect:/login";
        } else {
            returnAddress = "redirect:/reg?userExist=true";
        }

        return returnAddress;
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(value = "userExist", required = false) String exist,
                      Model model) {
        String errorMessage = null;
        if (exist != null) {
            errorMessage = "Такой пользователь уже существует. Введите другое имя пользователя!!!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "auth/reg";
    }
}