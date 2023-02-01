package org.workoutShuffle.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.workoutShuffle.entity.UserEntity;
import org.workoutShuffle.services.ExerciseService;
import org.workoutShuffle.services.UserService;
import org.workoutShuffle.services.WorkoutService;

@Controller
public class AppController {

    @Autowired
    private UserService userService;
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private WorkoutService workoutService;
    @Autowired
    private WorkoutSplitsService workoutSplitsService;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", userService.getUsers());
        modelAndView.addObject("exercises", exerciseService.getExercises());
        modelAndView.addObject("workoutTypes", workoutService.getWorkouts());
        modelAndView.addObject("workoutSplits", workoutSplitsService.getWorkoutSplits());
        return modelAndView;
    }
}
