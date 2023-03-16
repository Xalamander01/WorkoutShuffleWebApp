package org.workoutShuffle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() { return "index"; }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
