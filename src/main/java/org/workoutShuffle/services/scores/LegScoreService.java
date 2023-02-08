package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.LegScoreEntity;
import org.workoutShuffle.repository.scores.LegScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LegScoreService {

    @Autowired
    private LegScoreRepository legScoreRepository;

    public List<ExerciseEntity> getLegExercisesForWorkout(double workoutLegsGoal, Integer legsExerciseCount) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();

        return exerciseList;
    }

    public double getPushScore(LegScoreEntity legScoreEntity) {
        return legScoreEntity.getUpperQuadScore()+ legScoreEntity.getLowerQuadScore()+ legScoreEntity.getCalfScore();
    }
    public double getPullScore(LegScoreEntity legScoreEntity) {
        return legScoreEntity.getGluteMaxScore()+ legScoreEntity.getGluteMedScore()+ legScoreEntity.getHamstringScore();
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( LegScoreEntity exercise : getExercises() ) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }
    public double getAverageScore(LegScoreEntity legScoreEntity) {
        return (legScoreEntity.getGluteMaxScore()+ legScoreEntity.getGluteMedScore()+ legScoreEntity.getHamstringScore()+ legScoreEntity.getUpperQuadScore()+ legScoreEntity.getLowerQuadScore()+ legScoreEntity.getCalfScore())/6;
    }
    public double getSumOfScore(LegScoreEntity legScoreEntity) {
        return (legScoreEntity.getGluteMaxScore()+ legScoreEntity.getGluteMedScore()+ legScoreEntity.getHamstringScore()+ legScoreEntity.getUpperQuadScore()+ legScoreEntity.getLowerQuadScore()+ legScoreEntity.getCalfScore());
    }

    public List<LegScoreEntity> getExercises() {
        List<LegScoreEntity> exerciseLegScoreList = new ArrayList<>();
        for (LegScoreEntity exercise : legScoreRepository.findAll()) {
            exerciseLegScoreList.add(exercise);
        }
        return exerciseLegScoreList;
    }

    public LegScoreEntity getExerciseLegScore(String exerciseShortName) {
        return legScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseLegScore(LegScoreEntity exerciseLegScoreToAdd) {
        legScoreRepository.save(exerciseLegScoreToAdd);
    }

    public void updateExerciseLegScore(LegScoreEntity exerciseLegScoreToUpdate) {
        legScoreRepository.save(exerciseLegScoreToUpdate);
    }

    public void deleteExerciseLegScore(String exerciseShortName) {
        legScoreRepository.deleteById(exerciseShortName);
    }
}