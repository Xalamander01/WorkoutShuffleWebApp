package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.repository.ExerciseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( ExerciseEntity exercise : getExercises() ) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }


    public List<ExerciseEntity> getExercises() {
        List<ExerciseEntity> exerciseList = new ArrayList<>();
        for (ExerciseEntity exercise : exerciseRepository.findAll()) {
            exerciseList.add(exercise);
        }
        return exerciseList;
    }

    public ExerciseEntity getExercise(String exerciseShortName) {
        return exerciseRepository.findById(exerciseShortName).get();
    }

    public void addExercise(ExerciseEntity exerciseToAdd) {
        exerciseRepository.save(exerciseToAdd);
    }

    public void updateExercise(ExerciseEntity exerciseToUpdate) {
        exerciseRepository.save(exerciseToUpdate);
    }

    public void deleteExercise(String exerciseShortName) {
        exerciseRepository.deleteById(exerciseShortName);
    }
}
