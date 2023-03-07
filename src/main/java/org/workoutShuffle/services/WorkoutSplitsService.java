package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.WorkoutSplitsEntity;
import org.workoutShuffle.repository.WorkoutSplitsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class WorkoutSplitsService {

    @Autowired
    private WorkoutSplitsRepository workoutSplitsRepository;

    public List<String> getListOfWorkouts(WorkoutSplitsEntity workoutSplit) {
        List<String> listToReturn = new ArrayList<>();

        Collections.addAll(listToReturn, workoutSplit.getTypesOfWorkouts().split(","));
        return listToReturn;
    }

    /* check if the user-submitted workout preferences for repetition are fulfilled
    * simply put - check if the workout types in the split are varied enough
    */
    public boolean compareWorkoutCountAndRepTolerance(List<String> workoutTypesList, Integer repetitionTolerance) {

        boolean condition = false;
        List<WorkoutSplitsEntity> allWorkoutTypes = getWorkoutSplits();
        List<String> allWeeklyWorkoutTypes = new ArrayList<>();

        for (WorkoutSplitsEntity workoutSplit : allWorkoutTypes) {
            allWeeklyWorkoutTypes.add(workoutSplit.getTypesOfWorkouts());
        }

        HashSet<String> uniqueWords = new HashSet<>(workoutTypesList);
        List<String> uniqWorkoutTypesList = new ArrayList<>();
        uniqWorkoutTypesList.addAll(uniqueWords);

        if ((workoutTypesList.size() - uniqWorkoutTypesList.size()) <= (repetitionTolerance+1)) {
            condition = true;
        }

        return condition;
    }

    /* get the desired weekly workout types according to the user-submitted preferences
     */
    public List<String> getWeeklyWorkoutTypes(Integer workoutsPerWeek, Integer repetitionTolerance) {

        List<WorkoutSplitsEntity> allWorkoutTypes = getWorkoutSplits();
        List<WorkoutSplitsEntity> possibleWorkoutTypes = new ArrayList<>();

        for (WorkoutSplitsEntity workoutSplits : allWorkoutTypes) {
            if (workoutSplits.getWorkoutsPerWeek().equals(workoutsPerWeek)) {
                String workoutTypesInWorkout = workoutSplits.getTypesOfWorkouts();
                List<String> workoutTypesList = List.of(workoutTypesInWorkout.split(","));
                if (compareWorkoutCountAndRepTolerance(workoutTypesList, repetitionTolerance)) {
                    possibleWorkoutTypes.add(workoutSplits);
                }
            }
        }

        int randomInt = (int) Math.floor(Math.random() * (possibleWorkoutTypes.size()));
        WorkoutSplitsEntity workoutSplitToReturn = possibleWorkoutTypes.get(randomInt);

        return getListOfWorkouts(workoutSplitToReturn);
    }

    // =================== crud methods below ===================
    public List<WorkoutSplitsEntity> getWorkoutSplits() {
        List<WorkoutSplitsEntity> workoutSplitsList = new ArrayList<>();
        for (WorkoutSplitsEntity workoutSplit : workoutSplitsRepository.findAll()) {
            workoutSplitsList.add(workoutSplit);
        }
        return workoutSplitsList;
    }

    public WorkoutSplitsEntity getWorkoutSplit(String workoutSplit) {
        return workoutSplitsRepository.findById(workoutSplit).get();
    }

    public void addWorkoutSplit(WorkoutSplitsEntity workoutSplitToAdd) {
        workoutSplitsRepository.save(workoutSplitToAdd);
    }

    public void updateWorkoutSplit(WorkoutSplitsEntity workoutSplitToUpdate) {
        workoutSplitsRepository.save(workoutSplitToUpdate);
    }

    public void deleteWorkoutSplit(String workoutSplit) {
        workoutSplitsRepository.deleteById(workoutSplit);
    }
}
