package org.workoutShuffle.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
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

        return (List<ExerciseEntity>) workoutService.getExerciseList(workoutType, new ArrayList<>())[0];
    }

    @GetMapping("/allExercises")
    public List<ExerciseEntity> getAllExercises() {
        return exerciseService.getExercises();
    }

    /* generate a weekly workout split according to the users preferences */
    @GetMapping("/weeklyWorkouts/{workoutsPerWeek}/{repetitionTolerance}")
    public Map<String, List<ExerciseEntity>> viewWeeklyWorkouts(HttpSession session, @PathVariable("workoutsPerWeek") Integer workoutsPerWeek, @PathVariable("repetitionTolerance") Integer repetitionTolerance) {

        return workoutService.checkForWorkoutsMap(session, workoutsPerWeek, repetitionTolerance);
    }
}