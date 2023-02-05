package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.repository.ExerciseRepository;
import org.workoutShuffle.services.scores.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.sum;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ExerciseArmScoreService exerciseArmScoreService;
    @Autowired
    private ExerciseShoulderScoreService exerciseShoulderScoreService;
    @Autowired
    private ExerciseChestScoreService exerciseChestScoreService;
    @Autowired
    private ExerciseBackScoreService exerciseBackScoreService;
    @Autowired
    private ExerciseLegScoreService exerciseLegScoreService;

    public List<ExerciseEntity> getExercisesForMuscleGroup(double exerciseScoreGoal, Integer exerciseCountGoal, List<String> allExerciseShortNames, String serviceClassName, String workoutType) {
        List<ExerciseEntity> allExercises = getExercises();
        List<ExerciseEntity> exerciseListToReturn = new ArrayList<>();
        double scoreSoFar = 0;
        double scoreToAdd;
        System.out.println("STARTING TO GET EXERCISES WITH SERVICE " + serviceClassName);

        while ((exerciseListToReturn.size() < exerciseCountGoal) || (scoreSoFar < exerciseScoreGoal)) {

            if (exerciseListToReturn.size() == exerciseCountGoal && scoreSoFar < exerciseScoreGoal) {
                exerciseListToReturn = new ArrayList<>();
                scoreSoFar = 0;
                //System.out.println("STARTING OVER....");
            }
            int randomInt = (int) Math.floor(Math.random() * (allExerciseShortNames.size()));
            String currentExerciseShortName = allExerciseShortNames.get(randomInt);

            ExerciseEntity currentExercise = new ExerciseEntity();
            for (ExerciseEntity exercise : allExercises) {
                if (currentExerciseShortName.equals(exercise.getExerciseShortName())) {
                    currentExercise = exercise;
                }
            }

            if (!exerciseListToReturn.contains(currentExercise)) {
                scoreToAdd = 0;
                exerciseListToReturn.add(currentExercise);
                boolean needPushScore = workoutType.equals("push") || workoutType.equals("fullBody") || workoutType.equals("upper");
                boolean needPullScore = workoutType.equals("pull") || workoutType.equals("fullBody") || workoutType.equals("upper");
                switch (serviceClassName) {
                    case "org.workoutShuffle.services.scores.ExerciseArmScoreService":
                        if (needPushScore) {
                            scoreToAdd = exerciseArmScoreService.getPushScore(exerciseArmScoreService.getExerciseArmScore(currentExerciseShortName));
                        }
                        if (needPullScore) {
                            scoreToAdd = exerciseArmScoreService.getPullScore(exerciseArmScoreService.getExerciseArmScore(currentExerciseShortName));
                        }
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseShoulderScoreService":
                        if (needPushScore) {
                            scoreToAdd = exerciseShoulderScoreService.getPushScore(exerciseShoulderScoreService.getExerciseShoulderScore(currentExerciseShortName));
                        }
                        if (needPullScore) {
                            scoreToAdd = exerciseShoulderScoreService.getPullScore(exerciseShoulderScoreService.getExerciseShoulderScore(currentExerciseShortName));
                        }
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseChestScoreService":
                        scoreToAdd = exerciseChestScoreService.getAverageScore(exerciseChestScoreService.getExerciseChestScore(currentExerciseShortName));
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseBackScoreService":
                        scoreToAdd = exerciseBackScoreService.getAverageScore(exerciseBackScoreService.getExerciseBackScore(currentExerciseShortName));
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseLegScoreService":
                        scoreToAdd = (exerciseLegScoreService.getPushScore(exerciseLegScoreService.getExerciseLegScore(currentExerciseShortName))+exerciseLegScoreService.getPullScore(exerciseLegScoreService.getExerciseLegScore(currentExerciseShortName)))/2;
                        break;
                }
                scoreSoFar = sum(scoreSoFar, scoreToAdd);
            }
        }
        System.out.println("THE GOAL HAS BEEN REACHED BECAUSE WE GOT " + scoreSoFar + " SO FAR AND THE GOAL IS " + exerciseScoreGoal + " WITH ");
        for ( ExerciseEntity exercise : exerciseListToReturn) {
            System.out.println(exercise.toString());
        }

        return exerciseListToReturn;
    }


    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for (ExerciseEntity exercise : getExercises()) {
            allExercisesList.add(exercise.getExerciseShortName());
        }
        return allExercisesList;
    }


    public List<ExerciseEntity> getExercises() {
        List<ExerciseEntity> exerciseList = new ArrayList<>();
        for (ExerciseEntity exercise : exerciseRepository.findAll()) {
            exerciseList.add(exercise);
        }
        return exerciseList;
    }

    public ExerciseEntity getExercise(String exerciseShortName) {
        return exerciseRepository.findById(exerciseShortName).get();
    }

    public void addExercise(ExerciseEntity exerciseToAdd) {
        exerciseRepository.save(exerciseToAdd);
    }

    public void updateExercise(ExerciseEntity exerciseToUpdate) {
        exerciseRepository.save(exerciseToUpdate);
    }

    public void deleteExercise(String exerciseShortName) {
        exerciseRepository.deleteById(exerciseShortName);
    }
}
