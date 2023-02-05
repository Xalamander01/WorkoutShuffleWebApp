package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ExerciseBackScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseBackScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseBackScoreService {

    @Autowired
    private ExerciseBackScoreRepository exerciseBackScoreRepository;


    public List<ExerciseEntity> getBackExercisesForWorkout(double workoutBackGoal, Integer backExerciseCount) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();

        return exerciseList;
    }

    public double getAverageScore(ExerciseBackScoreEntity exerciseBackScoreEntity) {
        return (exerciseBackScoreEntity.getExerciseUpperTrapScore() + exerciseBackScoreEntity.getExerciseLowerTrapScore() + exerciseBackScoreEntity.getExerciseUpperLatScore() + exerciseBackScoreEntity.getExerciseLowerLatScore());
    }

    public double getSumOfScore(ExerciseBackScoreEntity exerciseBackScoreEntity) {
        return (exerciseBackScoreEntity.getExerciseUpperTrapScore() + exerciseBackScoreEntity.getExerciseLowerTrapScore() + exerciseBackScoreEntity.getExerciseUpperLatScore() + exerciseBackScoreEntity.getExerciseLowerLatScore());
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for (ExerciseBackScoreEntity exercise : getExercises()) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }

    public List<ExerciseBackScoreEntity> getExercises() {
        List<ExerciseBackScoreEntity> exerciseBackScoreList = new ArrayList<>();
        for (ExerciseBackScoreEntity exercise : exerciseBackScoreRepository.findAll()) {
            exerciseBackScoreList.add(exercise);
        }
        return exerciseBackScoreList;
    }

    public ExerciseBackScoreEntity getExerciseBackScore(String exerciseShortName) {
        return exerciseBackScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseBackScore(ExerciseBackScoreEntity exerciseBackScoreToAdd) {
        exerciseBackScoreRepository.save(exerciseBackScoreToAdd);
    }

    public void updateExerciseBackScore(ExerciseBackScoreEntity exerciseBackScoreToUpdate) {
        exerciseBackScoreRepository.save(exerciseBackScoreToUpdate);
    }

    public void deleteExerciseBackScore(String exerciseShortName) {
        exerciseBackScoreRepository.deleteById(exerciseShortName);
    }
}