package org.workoutShuffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.workoutShuffle.services.ExerciseService;
import org.workoutShuffle.services.UserService;
import org.workoutShuffle.services.WorkoutService;
import org.workoutShuffle.services.WorkoutSplitsService;

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
    public String home() {
        return "index";
    }
    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
