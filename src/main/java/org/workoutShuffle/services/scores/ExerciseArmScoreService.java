package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ExerciseArmScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseArmScoreRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExerciseArmScoreService {

    @Autowired
    private ExerciseArmScoreRepository exerciseArmScoreRepository;

    public List<ExerciseArmScoreEntity> getExercises() {
        List<ExerciseArmScoreEntity> exerciseArmScoreList = new ArrayList<>();
        for (ExerciseArmScoreEntity exercise : exerciseArmScoreRepository.findAll()) {
            exerciseArmScoreList.add(exercise);
        }
        return exerciseArmScoreList;
    }

    public ExerciseArmScoreEntity getExerciseArmScore(String exerciseShortName) {
        return exerciseArmScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseArmScore(ExerciseArmScoreEntity exerciseArmScoreToAdd) {
        exerciseArmScoreRepository.save(exerciseArmScoreToAdd);
    }

    public void updateExerciseArmScore(ExerciseArmScoreEntity exerciseArmScoreToUpdate) {
        exerciseArmScoreRepository.save(exerciseArmScoreToUpdate);
    }

    public void deleteExerciseArmScore(String exerciseShortName) {
        exerciseArmScoreRepository.deleteById(exerciseShortName);
    }

    public List<ExerciseEntity> getArmExercises() {
        List<ExerciseEntity> exerciseList = new ArrayList<>();

        return exerciseList;
    }
}
