package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ExerciseLegScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseLegScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseLegScoreService {

    @Autowired
    private ExerciseLegScoreRepository exerciseLegScoreRepository;

    public List<ExerciseEntity> getLegExercisesForWorkout(double workoutLegsGoal, Integer legsExerciseCount) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();

        return exerciseList;
    }

    public double getPushScore(ExerciseLegScoreEntity exerciseLegScoreEntity) {
        return exerciseLegScoreEntity.getExerciseUpperQuadScore()+exerciseLegScoreEntity.getExerciseLowerQuadScore()+exerciseLegScoreEntity.getExerciseCalfScore();
    }
    public double getPullScore(ExerciseLegScoreEntity exerciseLegScoreEntity) {
        return exerciseLegScoreEntity.getExerciseGluteMaxScore()+exerciseLegScoreEntity.getExerciseGluteMedScore()+exerciseLegScoreEntity.getExerciseHamstringScore();
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( ExerciseLegScoreEntity exercise : getExercises() ) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }
    public double getAverageScore(ExerciseLegScoreEntity exerciseLegScoreEntity) {
        return (exerciseLegScoreEntity.getExerciseGluteMaxScore()+exerciseLegScoreEntity.getExerciseGluteMedScore()+exerciseLegScoreEntity.getExerciseHamstringScore()+exerciseLegScoreEntity.getExerciseUpperQuadScore()+exerciseLegScoreEntity.getExerciseLowerQuadScore()+exerciseLegScoreEntity.getExerciseCalfScore())/6;
    }
    public double getSumOfScore(ExerciseLegScoreEntity exerciseLegScoreEntity) {
        return (exerciseLegScoreEntity.getExerciseGluteMaxScore()+exerciseLegScoreEntity.getExerciseGluteMedScore()+exerciseLegScoreEntity.getExerciseHamstringScore()+exerciseLegScoreEntity.getExerciseUpperQuadScore()+exerciseLegScoreEntity.getExerciseLowerQuadScore()+exerciseLegScoreEntity.getExerciseCalfScore());
    }

    public List<ExerciseLegScoreEntity> getExercises() {
        List<ExerciseLegScoreEntity> exerciseLegScoreList = new ArrayList<>();
        for (ExerciseLegScoreEntity exercise : exerciseLegScoreRepository.findAll()) {
            exerciseLegScoreList.add(exercise);
        }
        return exerciseLegScoreList;
    }

    public ExerciseLegScoreEntity getExerciseLegScore(String exerciseShortName) {
        return exerciseLegScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseLegScore(ExerciseLegScoreEntity exerciseLegScoreToAdd) {
        exerciseLegScoreRepository.save(exerciseLegScoreToAdd);
    }

    public void updateExerciseLegScore(ExerciseLegScoreEntity exerciseLegScoreToUpdate) {
        exerciseLegScoreRepository.save(exerciseLegScoreToUpdate);
    }

    public void deleteExerciseLegScore(String exerciseShortName) {
        exerciseLegScoreRepository.deleteById(exerciseShortName);
    }
}