package org.workoutShuffle.services.scores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.scores.ExerciseArmScoreEntity;
import org.workoutShuffle.repository.scores.ExerciseArmScoreRepository;
import org.workoutShuffle.services.ExerciseService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.sum;

@Service
public class ExerciseArmScoreService {

    @Autowired
    private ExerciseArmScoreRepository exerciseArmScoreRepository;
    @Autowired
    private ExerciseService exerciseService;

    public List<ExerciseEntity> getArmExercisesForWorkout(double armExerciseScoreGoal, Integer armExerciseCountGoal) {

        List<String> allExerciseShortNames = getAllExerciseShortNames();
        List<ExerciseEntity> allExercises = exerciseService.getExercises();
        List<ExerciseEntity> exerciseListToReturn = new ArrayList<>();
        double armScoreSoFar = 0;

        while ( (exerciseListToReturn.size() < armExerciseCountGoal) || (armScoreSoFar < armExerciseScoreGoal)) {

            if ( exerciseListToReturn.size() == armExerciseCountGoal && armScoreSoFar < armExerciseScoreGoal ) {
                exerciseListToReturn = new ArrayList<>();
                armScoreSoFar = 0;
            }
            int randomInt = (int) Math.floor(Math.random() * (allExerciseShortNames.size()));
            String currentExerciseShortName = allExerciseShortNames.get(randomInt);

            ExerciseEntity currentExercise = new ExerciseEntity();
            //ExerciseEntity currentExercise = exerciseService.getExercise(currentExerciseShortName);
            for ( ExerciseEntity exercise : allExercises) {
                if ( currentExerciseShortName.equals(exercise.getExerciseShortName())) {
                    currentExercise = exercise;
                }
            }

            if (!exerciseListToReturn.contains(currentExercise)) {
                exerciseListToReturn.add(currentExercise);
                armScoreSoFar = sum(armScoreSoFar, getAverageScore(getExerciseArmScore(currentExerciseShortName)));
            }
            System.out.println( " THE SCORE COMPARISON RETURNS " + (armScoreSoFar < armExerciseScoreGoal) + " WHEN THE GOAL IS " + armExerciseScoreGoal + " AND WE GOT " + armScoreSoFar);
        }
        System.out.println("THE GOAL HAS BEEN REACHED BECAUSE WE GOT " + armScoreSoFar + " SO FAR AND THE GOAL IS " + armExerciseScoreGoal);

        return exerciseListToReturn;
    }

    public double getAverageScore(ExerciseArmScoreEntity exerciseArmScore) {
        return (exerciseArmScore.getExerciseForearmScore() + exerciseArmScore.getExerciseInnerBiScore() + exerciseArmScore.getExerciseOuterBiScore() + exerciseArmScore.getExerciseLatTriScore() + exerciseArmScore.getExerciseMedTriScore() + exerciseArmScore.getExerciseLongTriScore()) / 3;
    }

    public double getSumOfScore(ExerciseArmScoreEntity exerciseArmScore) {
        return (exerciseArmScore.getExerciseForearmScore() + exerciseArmScore.getExerciseInnerBiScore() + exerciseArmScore.getExerciseOuterBiScore() + exerciseArmScore.getExerciseLatTriScore() + exerciseArmScore.getExerciseMedTriScore() + exerciseArmScore.getExerciseLongTriScore());
    }

    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( ExerciseArmScoreEntity exercise : getExercises() ) {
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
