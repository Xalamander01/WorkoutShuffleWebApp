package org.workoutShuffle.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.services.ExerciseService;
import org.workoutShuffle.services.WorkoutService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@SessionAttributes("workoutsMap")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;
    @Autowired
    ExerciseService exerciseService;

    /* generate a single workout if that is what the user has chosen */
    @GetMapping("/singleWorkout/{workoutType}")
    public List<ExerciseEntity> processSingleUserPreference(@PathVariable("workoutType") String workoutType) {
        List<ExerciseEntity> exerciseList = null;
        if ( workoutType != null ) {
            exerciseList = workoutService.getExerciseList(workoutType);
        }
        return exerciseList;
    }

    @GetMapping("/allExercises")
    public List<ExerciseEntity> getAllExercises() {
        return exerciseService.getExercises();
    }

    /* generate a weekly workout split according to the users preferences */
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

    /* regenerate a workout, this does not work yet */
    @GetMapping("/refreshWorkout")
    public ModelAndView getNewWorkout() {
        ModelAndView modelAndView = new ModelAndView("weekly_workout_list");
        // TO_DO implement this
        return modelAndView;
    }
}