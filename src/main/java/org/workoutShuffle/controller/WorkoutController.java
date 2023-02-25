package org.workoutShuffle.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.services.WorkoutService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("workoutsMap")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("/singleWorkout")
    public ModelAndView processSingleUserPreference(@PathParam("workoutType") String workoutType) {
        ModelAndView modelAndView = new ModelAndView("weekly_workout_list");
        List<ExerciseEntity> exerciseList = workoutService.getExerciseList(workoutType);
        modelAndView.addObject("workoutsPerWeek", 0);
        modelAndView.addObject("repetitionTolerance", 0);
        modelAndView.addObject("workoutType", workoutType);
        modelAndView.addObject("exerciseList", exerciseList);
        return modelAndView;
    }

    @GetMapping("/weeklyWorkouts")
    public ModelAndView viewWeeklyWorkouts(HttpSession session, @PathParam("workoutsPerWeek") Integer workoutsPerWeek, @PathParam("repetitionTolerance") Integer repetitionTolerance, @PathParam("workoutDay") Integer workoutDay) {
        ModelAndView modelAndView = new ModelAndView("weekly_workout_list");
        Map<String, List<ExerciseEntity>> workoutsMap = workoutService.checkForWorkoutsMap(session, workoutsPerWeek, repetitionTolerance);
        List<String> workoutTypes = new ArrayList<>(workoutsMap.keySet());
        modelAndView.addObject("workoutsPerWeek", workoutsPerWeek);
        modelAndView.addObject("repetitionTolerance", repetitionTolerance);
        modelAndView.addObject("workoutTypes", workoutService.getWorkoutTypesForJSP(workoutTypes));
        modelAndView.addObject("exerciseList", workoutsMap.get(workoutTypes.get((workoutDay - 1))));

        return modelAndView;
    }

    @GetMapping("/refreshWorkout")
    public ModelAndView getNewWorkout() {
        ModelAndView modelAndView = new ModelAndView("weekly_workout_list");
        // TO_DO implement this
        return modelAndView;
    }
}