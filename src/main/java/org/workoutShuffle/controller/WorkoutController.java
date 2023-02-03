package org.workoutShuffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.entity.WorkoutSplitsEntity;
import org.workoutShuffle.services.WorkoutService;
import org.workoutShuffle.services.scores.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    public WorkoutSplitsEntity processWeeklyUserPreference(Integer workoutsPerWeek, Integer repetitionTolerance) {
        return null;
    }

    @GetMapping("/submitSingleWorkoutPreferences")
    public ModelAndView processSingleUserPreference(String workoutType) {
        ModelAndView modelAndView = new ModelAndView("workout_list");
        List<ExerciseEntity> exerciseList = workoutService.getExerciseList(workoutType);

        //call the service for each main muscle group
        //give them number of exercises and score goals
        //let them calculate how the score can be reached with the given number of exercises
        //append to list
        //return

        modelAndView.addObject(exerciseList);
        return modelAndView;
    }

}
