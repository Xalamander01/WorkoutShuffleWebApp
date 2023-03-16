package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.scores.ShoulderScoreEntity;
import org.workoutShuffle.repository.scores.ShoulderScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoulderScoreService {

    @Autowired
    private ShoulderScoreRepository shoulderScoreRepository;

    //methods to get the exercise score, depending on user preferences
    public double getPushScore(ShoulderScoreEntity shoulderScoreEntity) {
        return shoulderScoreEntity.getFrontShoulderScore();
    }

    public double getPullScore(ShoulderScoreEntity shoulderScoreEntity) {
        return (shoulderScoreEntity.getSideShoulderScore() + shoulderScoreEntity.getRearShoulderScore());
    }

    public double getAverageScore(ShoulderScoreEntity shoulderScoreEntity) {
        return (shoulderScoreEntity.getFrontShoulderScore() + shoulderScoreEntity.getRearShoulderScore() + shoulderScoreEntity.getSideShoulderScore()) / 3;
    }

    public double getSumOfScore(ShoulderScoreEntity shoulderScoreEntity) {
        return (shoulderScoreEntity.getFrontShoulderScore() + shoulderScoreEntity.getRearShoulderScore() + shoulderScoreEntity.getSideShoulderScore());
    }

    //method to get the short names (id) of all exercises of this group
    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for (ShoulderScoreEntity exercise : getExercises()) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }
    // =================== crud methods below ===================
    public List<ShoulderScoreEntity> getExercises() {
        List<ShoulderScoreEntity> exerciseShoulderScoreList = new ArrayList<>();
        for (ShoulderScoreEntity exercise : shoulderScoreRepository.findAll()) {
            exerciseShoulderScoreList.add(exercise);
        }
        return exerciseShoulderScoreList;
    }

    public ShoulderScoreEntity getExerciseShoulderScore(String exerciseShortName) {
        return shoulderScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseShoulderScore(ShoulderScoreEntity exerciseShoulderScoreToAdd) {
        shoulderScoreRepository.save(exerciseShoulderScoreToAdd);
    }

    public void updateExerciseShoulderScore(ShoulderScoreEntity exerciseShoulderScoreToUpdate) {
        shoulderScoreRepository.save(exerciseShoulderScoreToUpdate);
    }

    public void deleteExerciseShoulderScore(String exerciseShortName) {
        shoulderScoreRepository.deleteById(exerciseShortName);
    }
}