package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ExerciseArmScoreEntity;
import org.workoutShuffle.entity.scores.ExerciseShoulderScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseShoulderScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseShoulderScoreService {

    @Autowired
    private ExerciseShoulderScoreRepository exerciseShoulderScoreRepository;

    public List<ExerciseEntity> getShoulderExercisesForWorkout(double workoutShoulderGoal, Integer shoulderExerciseCount) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();

        return exerciseList;
    }

    public double getPushScore(ExerciseShoulderScoreEntity exerciseShoulderScoreEntity) {
        return exerciseShoulderScoreEntity.getExerciseFrontShoulderScore();
    }

    public double getPullScore(ExerciseShoulderScoreEntity exerciseShoulderScoreEntity) {
        return exerciseShoulderScoreEntity.getExerciseSideShoulderScore() + exerciseShoulderScoreEntity.getExerciseRearShoulderScore();
    }

    public double getAverageScore(ExerciseShoulderScoreEntity exerciseShoulderScoreEntity) {
        return (exerciseShoulderScoreEntity.getExerciseFrontShoulderScore() + exerciseShoulderScoreEntity.getExerciseRearShoulderScore() + exerciseShoulderScoreEntity.getExerciseSideShoulderScore()) / 3;
    }

    public double getSumOfScore(ExerciseShoulderScoreEntity exerciseShoulderScoreEntity) {
        return (exerciseShoulderScoreEntity.getExerciseFrontShoulderScore() + exerciseShoulderScoreEntity.getExerciseRearShoulderScore() + exerciseShoulderScoreEntity.getExerciseSideShoulderScore());
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( ExerciseShoulderScoreEntity exercise : getExercises() ) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }
    public List<ExerciseShoulderScoreEntity> getExercises() {
        List<ExerciseShoulderScoreEntity> exerciseShoulderScoreList = new ArrayList<>();
        for (ExerciseShoulderScoreEntity exercise : exerciseShoulderScoreRepository.findAll()) {
            exerciseShoulderScoreList.add(exercise);
        }
        return exerciseShoulderScoreList;
    }

    public ExerciseShoulderScoreEntity getExerciseShoulderScore(String exerciseShortName) {
        return exerciseShoulderScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseShoulderScore(ExerciseShoulderScoreEntity exerciseShoulderScoreToAdd) {
        exerciseShoulderScoreRepository.save(exerciseShoulderScoreToAdd);
    }

    public void updateExerciseShoulderScore(ExerciseShoulderScoreEntity exerciseShoulderScoreToUpdate) {
        exerciseShoulderScoreRepository.save(exerciseShoulderScoreToUpdate);
    }

    public void deleteExerciseShoulderScore(String exerciseShortName) {
        exerciseShoulderScoreRepository.deleteById(exerciseShortName);
    }
}