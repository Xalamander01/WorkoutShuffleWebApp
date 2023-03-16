package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ChestScoreEntity;
import org.workoutShuffle.repository.scores.ChestScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChestScoreService {

    @Autowired
    private ChestScoreRepository chestScoreRepository;

    //methods to get the exercise score, depending on user preferences
    public double getAverageScore(ChestScoreEntity chestScoreEntity) {
        return (chestScoreEntity.getUpperPecScore()+ chestScoreEntity.getMiddlePecScore()+ chestScoreEntity.getLowerPecScore())/3;
    }
    public double getSumOfScore(ChestScoreEntity chestScoreEntity) {
        return (chestScoreEntity.getUpperPecScore()+ chestScoreEntity.getMiddlePecScore()+ chestScoreEntity.getLowerPecScore());
    }

    //method to get the short names (id) of all exercises of this group
    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( ChestScoreEntity exercise : getExercises() ) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }

    // =================== crud methods below ===================
    public List<ChestScoreEntity> getExercises() {
        List<ChestScoreEntity> exerciseChestScoreList = new ArrayList<>();
        for (ChestScoreEntity exercise : chestScoreRepository.findAll()) {
            exerciseChestScoreList.add(exercise);
        }
        return exerciseChestScoreList;
    }

    public ChestScoreEntity getExerciseChestScore(String exerciseShortName) {
        return chestScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseChestScore(ChestScoreEntity exerciseChestScoreToAdd) {
        chestScoreRepository.save(exerciseChestScoreToAdd);
    }

    public void updateExerciseChestScore(ChestScoreEntity exerciseChestScoreToUpdate) {
        chestScoreRepository.save(exerciseChestScoreToUpdate);
    }

    public void deleteExerciseChestScore(String exerciseShortName) {
        chestScoreRepository.deleteById(exerciseShortName);
    }
}