package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ExerciseArmScoreEntity;
import org.workoutShuffle.entity.scores.ExerciseChestScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseChestScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseChestScoreService {

    @Autowired
    private ExerciseChestScoreRepository exerciseChestScoreRepository;

    public List<ExerciseEntity> getChestExercisesForWorkout(double workoutChestGoal, Integer chestExerciseCount) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();

        return exerciseList;
    }

    public double getAverageScore(ExerciseChestScoreEntity exerciseChestScoreEntity) {
        return (exerciseChestScoreEntity.getExerciseUpperPecScore()+exerciseChestScoreEntity.getExerciseMiddlePecScore()+exerciseChestScoreEntity.getExerciseLowerPecScore())/3;
    }
    public double getSumOfScore(ExerciseChestScoreEntity exerciseChestScoreEntity) {
        return (exerciseChestScoreEntity.getExerciseUpperPecScore()+exerciseChestScoreEntity.getExerciseMiddlePecScore()+exerciseChestScoreEntity.getExerciseLowerPecScore());
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( ExerciseChestScoreEntity exercise : getExercises() ) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }

    public List<ExerciseChestScoreEntity> getExercises() {
        List<ExerciseChestScoreEntity> exerciseChestScoreList = new ArrayList<>();
        for (ExerciseChestScoreEntity exercise : exerciseChestScoreRepository.findAll()) {
            exerciseChestScoreList.add(exercise);
        }
        return exerciseChestScoreList;
    }

    public ExerciseChestScoreEntity getExerciseChestScore(String exerciseShortName) {
        return exerciseChestScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseChestScore(ExerciseChestScoreEntity exerciseChestScoreToAdd) {
        exerciseChestScoreRepository.save(exerciseChestScoreToAdd);
    }

    public void updateExerciseChestScore(ExerciseChestScoreEntity exerciseChestScoreToUpdate) {
        exerciseChestScoreRepository.save(exerciseChestScoreToUpdate);
    }

    public void deleteExerciseChestScore(String exerciseShortName) {
        exerciseChestScoreRepository.deleteById(exerciseShortName);
    }
}