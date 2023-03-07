package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.repository.ExerciseRepository;
import org.workoutShuffle.services.scores.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


import static java.lang.Double.sum;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ArmScoreService armScoreService;
    @Autowired
    private ShoulderScoreService shoulderScoreService;
    @Autowired
    private ChestScoreService chestScoreService;
    @Autowired
    private BackScoreService backScoreService;
    @Autowired
    private LegScoreService legScoreService;

    /*
        return the service object based on class name
     */
    public Map<String, Object> getServiceNameAndServiceMap() {
        Map<String, Object> serviceNameAndObjectMap = new HashMap<>();
        serviceNameAndObjectMap.put(armScoreService.getClass().getName(), armScoreService);
        serviceNameAndObjectMap.put(shoulderScoreService.getClass().getName(), shoulderScoreService);
        serviceNameAndObjectMap.put(chestScoreService.getClass().getName(), chestScoreService);
        serviceNameAndObjectMap.put(backScoreService.getClass().getName(), backScoreService);
        serviceNameAndObjectMap.put(legScoreService.getClass().getName(), legScoreService);
        return serviceNameAndObjectMap;
    }

    /*
        generate a list of exercises for each muscle group
        the selected exercises must satisfy the scoring criteria
     */
    public List<ExerciseEntity> getExercisesForMuscleGroup(double exerciseScoreGoal, Integer exerciseCountGoal, List<String> allExerciseShortNames, String serviceClassName, String entityName, String getScoreMethod, String getterMethod) {
        Map<String, Object> serviceNameAndServiceMap = getServiceNameAndServiceMap();
        List<ExerciseEntity> allExercises = getExercises();
        List<ExerciseEntity> exerciseListToReturn = new ArrayList<>();

        double scoreSoFar = 0;
        double scoreToAdd;

        while ((exerciseListToReturn.size() < exerciseCountGoal) || (scoreSoFar < exerciseScoreGoal)) {

            if (exerciseListToReturn.size() == exerciseCountGoal && scoreSoFar < exerciseScoreGoal) {
                exerciseListToReturn = new ArrayList<>();
                scoreSoFar = 0;
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
                exerciseListToReturn.add(currentExercise);
                try {

                    Method entityMethod = Class.forName(serviceClassName).getDeclaredMethod(getterMethod, String.class);
                    Object entity = entityMethod.invoke(serviceNameAndServiceMap.get(serviceClassName), currentExerciseShortName);

                    Method method = Class.forName(serviceClassName).getDeclaredMethod(getScoreMethod, Class.forName(entityName));
                    scoreToAdd = (double) method.invoke(serviceNameAndServiceMap.get(serviceClassName), entity);
                } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                scoreSoFar = sum(scoreSoFar, scoreToAdd);
            }
        }

        return exerciseListToReturn;
    }

    // =================== crud methods below ===================
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
