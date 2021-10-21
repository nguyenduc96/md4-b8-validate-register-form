package com.nguyenduc.controller;

import com.nguyenduc.model.User;
import com.nguyenduc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/home")
    public ModelAndView home() {
        List<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        return new ModelAndView("register", "user", new User());
    }

    @PostMapping("/save")
    public ModelAndView create(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("register");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        boolean isSave = userService.save(user);
        if (!isSave) {
            return modelAndView.addObject("message", "tk da toan tai");
        }
        System.out.println(isSave);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
