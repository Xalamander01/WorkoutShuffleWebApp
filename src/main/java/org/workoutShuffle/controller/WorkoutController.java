package org.workoutShuffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.entity.WorkoutSplitsEntity;
import org.workoutShuffle.services.ExerciseService;
import org.workoutShuffle.services.WorkoutService;

import java.util.List;

@Controller
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @Autowired
    ExerciseService exerciseService;

    public WorkoutSplitsEntity processWeeklyUserPreference(Integer workoutsPerWeek, Integer repetitionTolerance) {
        return null;
    }

    @GetMapping("/submitSingleWorkoutPreferences")
    public ModelAndView processSingleUserPreference(String workoutType) {
        ModelAndView modelAndView = new ModelAndView("workout_list");
        List<ExerciseEntity> exerciseList = workoutService.getExerciseList(workoutType);
        WorkoutEntity workoutEntity = workoutService.getWorkout(workoutType);
        modelAndView.addObject("workoutEntity", workoutEntity);
        modelAndView.addObject("listSize", exerciseList.size());
        modelAndView.addObject("exerciseList", exerciseList);
        return modelAndView;
    }
}
