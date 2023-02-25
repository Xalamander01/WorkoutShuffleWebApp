package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.scores.ArmScoreEntity;
import org.workoutShuffle.repository.scores.ArmScoreRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArmScoreService {

    @Autowired
    private ArmScoreRepository armScoreRepository;

    public double getPushScore(ArmScoreEntity exerciseArmScore) {
        return (exerciseArmScore.getLatTriScore() + exerciseArmScore.getMedTriScore() + exerciseArmScore.getLongTriScore()) / 3;
    }

    public double getPullScore(ArmScoreEntity exerciseArmScore) {
        return (exerciseArmScore.getInnerBiScore() + exerciseArmScore.getOuterBiScore()) / 2;
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for (ArmScoreEntity exercise : getExercises()) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }

    // =================== crud methods below ===================
    public List<ArmScoreEntity> getExercises() {
        List<ArmScoreEntity> exerciseArmScoreList = new ArrayList<>();
        for (ArmScoreEntity exercise : armScoreRepository.findAll()) {
            exerciseArmScoreList.add(exercise);
        }
        return exerciseArmScoreList;
    }

    public ArmScoreEntity getExerciseArmScore(String exerciseShortName) {
        return armScoreRepository.findById(exerciseShortName).get();
    }

    public void addExerciseArmScore(ArmScoreEntity exerciseArmScoreToAdd) {
        armScoreRepository.save(exerciseArmScoreToAdd);
    }

    public void updateExerciseArmScore(ArmScoreEntity exerciseArmScoreToUpdate) {
        armScoreRepository.save(exerciseArmScoreToUpdate);
    }

    public void deleteExerciseArmScore(String exerciseShortName) {
        armScoreRepository.deleteById(exerciseShortName);
    }
}
