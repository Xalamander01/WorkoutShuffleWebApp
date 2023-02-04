package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.scores.ExerciseArmScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseArmScoreRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseArmScoreService {

    @Autowired
    private ExerciseArmScoreRepository exerciseArmScoreRepository;


    public List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        Field[] members = ExerciseArmScoreEntity.class.getDeclaredFields();
        for (Field member : members) {
            columnNames.add(member.getName());
        }
        return columnNames;
    }

    public double getPushScore(ExerciseArmScoreEntity exerciseArmScore) {
        return (exerciseArmScore.getExerciseLatTriScore() + exerciseArmScore.getExerciseMedTriScore() + exerciseArmScore.getExerciseLongTriScore()) / 3;
    }

    public double getPullScore(ExerciseArmScoreEntity exerciseArmScore) {
        return (exerciseArmScore.getExerciseInnerBiScore() + exerciseArmScore.getExerciseOuterBiScore()) / 2;
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for (ExerciseArmScoreEntity exercise : getExercises()) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }

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
}
