package org.workoutShuffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.services.ExerciseService;
import org.workoutShuffle.services.WorkoutService;
import org.workoutShuffle.services.WorkoutSplitsService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @Autowired
    WorkoutSplitsService workoutSplitsService;
    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/submitSingleWorkoutPreferences")
    public ModelAndView processSingleUserPreference(@PathVariable("workoutType") String workoutType) {
        ModelAndView modelAndView = new ModelAndView("workout_list");
        List<ExerciseEntity> exerciseList = workoutService.getExerciseList(workoutType);
        WorkoutEntity workoutEntity = workoutService.getWorkout(workoutType);
        modelAndView.addObject("workoutEntity", workoutEntity);
        modelAndView.addObject("listSize", exerciseList.size());
        modelAndView.addObject("exerciseList", exerciseList);
        return modelAndView;
    }

    @GetMapping("submitWeeklyWorkoutPreferences")
    public ModelAndView processWeeklyUserPreference(@PathVariable("workoutsPerWeek") Integer workoutsPerWeek, @PathVariable("repetitionTolerance") Integer repetitionTolerance) {
        ModelAndView modelAndView = new ModelAndView("workout_list");
        String[] workoutTypes = workoutSplitsService.getWeeklyWorkouts(workoutsPerWeek, repetitionTolerance);
        List<ExerciseEntity>[] exerciseListArray = new ArrayList[workoutsPerWeek];
        for (int i = 0; i < workoutTypes.length; i++) {
            exerciseListArray[i] = workoutService.getExerciseList(workoutTypes[i]);
        }
        modelAndView.addObject(exerciseListArray);
        return modelAndView;
    }
}
