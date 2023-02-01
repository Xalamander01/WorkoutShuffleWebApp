package org.workoutShuffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.entity.WorkoutSplitsEntity;
import org.workoutShuffle.services.WorkoutService;

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
        WorkoutEntity workoutEntity = workoutService.getWorkout(workoutType);
        ModelAndView modelAndView = new ModelAndView("workout_list");
        List<ExerciseEntity> exerciseList = new ArrayList<>();


        //we have the required scores for each muscle group
        //grab score and suggest a list of exercises
        //add each exercise to list

        modelAndView.addObject(workoutEntity);
        modelAndView.addObject(exerciseList);
        return modelAndView;
    }

}
