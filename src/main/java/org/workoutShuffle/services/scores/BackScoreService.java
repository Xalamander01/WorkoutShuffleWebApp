package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.BackScoreEntity;
import org.workoutShuffle.repository.scores.BackScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackScoreService {

    @Autowired
    private BackScoreRepository backScoreRepository;

    public double getAverageScore(BackScoreEntity backScoreEntity) {
        return (backScoreEntity.getUpperTrapScore() + backScoreEntity.getLowerTrapScore() + backScoreEntity.getUpperLatScore() + backScoreEntity.getLowerLatScore());
    }

    public double getSumOfScore(BackScoreEntity backScoreEntity) {
        return (backScoreEntity.getUpperTrapScore() + backScoreEntity.getLowerTrapScore() + backScoreEntity.getUpperLatScore() + backScoreEntity.getLowerLatScore());
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for (BackScoreEntity exercise : getExercises()) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }

    // =================== crud methods below ===================
    public List<BackScoreEntity> getExercises() {
        List<BackScoreEntity> exerciseBackScoreList = new ArrayList<>();
        for (BackScoreEntity exercise : backScoreRepository.findAll()) {
            exerciseBackScoreList.add(exercise);
        }
        return exerciseBackScoreList;
    }

    public BackScoreEntity getExerciseBackScore(String exerciseShortName) {
        return backScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseBackScore(BackScoreEntity exerciseBackScoreToAdd) {
        backScoreRepository.save(exerciseBackScoreToAdd);
    }

    public void updateExerciseBackScore(BackScoreEntity exerciseBackScoreToUpdate) {
        backScoreRepository.save(exerciseBackScoreToUpdate);
    }

    public void deleteExerciseBackScore(String exerciseShortName) {
        backScoreRepository.deleteById(exerciseShortName);
    }
}