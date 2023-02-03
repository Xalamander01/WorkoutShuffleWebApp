package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ExerciseChestScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseChestScoreRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExerciseChestScoreService {

    @Autowired
    private ExerciseChestScoreRepository exerciseChestScoreRepository;

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

    public List<ExerciseEntity> getChestExercises() {
        List<ExerciseEntity> exerciseList = new ArrayList<>();

        return exerciseList;
    }
}