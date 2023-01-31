package org.workoutShuffle.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.workoutShuffle.entity.UserEntity;
import org.workoutShuffle.services.UserService;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView home() {
        System.out.println(userService.getUser(7));
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }
}
