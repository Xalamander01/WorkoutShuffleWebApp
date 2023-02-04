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

    public List<ExerciseEntity> getExercisesForMuscleGroup(double exerciseScoreGoal, Integer exerciseCountGoal, List<String> allExerciseShortNames, String serviceClassName) {
        List<ExerciseEntity> allExercises = getExercises();
        List<ExerciseEntity> exerciseListToReturn = new ArrayList<>();
        double scoreSoFar = 0;
        double scoreToAdd;

        while ( (exerciseListToReturn.size() < exerciseCountGoal) || (scoreSoFar < exerciseScoreGoal)) {

            if ( exerciseListToReturn.size() == exerciseCountGoal && scoreSoFar < exerciseScoreGoal ) {
                exerciseListToReturn = new ArrayList<>();
                scoreSoFar = 0;
                //System.out.println("STARTING OVER....");
            }
            int randomInt = (int) Math.floor(Math.random() * (allExerciseShortNames.size()));
            String currentExerciseShortName = allExerciseShortNames.get(randomInt);

            ExerciseEntity currentExercise = new ExerciseEntity();
            for ( ExerciseEntity exercise : allExercises) {
                if ( currentExerciseShortName.equals(exercise.getExerciseShortName())) {
                    currentExercise = exercise;
                }
            }

            if (!exerciseListToReturn.contains(currentExercise)) {
                scoreToAdd = 0;
                exerciseListToReturn.add(currentExercise);
                switch(serviceClassName) {
                    case "org.workoutShuffle.services.scores.ExerciseArmScoreService":
                        scoreToAdd = exerciseArmScoreService.getPushScore(exerciseArmScoreService.getExerciseArmScore(currentExerciseShortName));
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseShoulderScoreService":
                        scoreToAdd = exerciseShoulderScoreService.getPushScore(exerciseShoulderScoreService.getExerciseShoulderScore(currentExerciseShortName));
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseChestScoreService":
                        scoreToAdd = exerciseChestScoreService.getSumOfScore(exerciseChestScoreService.getExerciseChestScore(currentExerciseShortName));
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseBackScoreService":
                        scoreToAdd = exerciseBackScoreService.getSumOfScore(exerciseBackScoreService.getExerciseBackScore(currentExerciseShortName));
                        break;
                    case "org.workoutShuffle.services.scores.ExerciseLegScoreService":
                        scoreToAdd = exerciseLegScoreService.getSumOfScore(exerciseLegScoreService.getExerciseLegScore(currentExerciseShortName));
                        break;
                }
                scoreSoFar = sum(scoreSoFar, scoreToAdd);
            }
        }
        /*
        System.out.println("THE GOAL HAS BEEN REACHED BECAUSE WE GOT " + scoreSoFar + " SO FAR AND THE GOAL IS " + armExerciseScoreGoal + " WITH ");
        for ( ExerciseEntity exercise : exerciseListToReturn) {
            System.out.println(exercise.toString());
        }
         */

        return exerciseListToReturn;
    }



    public List<String> getAllExerciseShortNames() {

        List<String> allExercisesList = new ArrayList<>();
        for ( ExerciseEntity exercise : getExercises() ) {
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
