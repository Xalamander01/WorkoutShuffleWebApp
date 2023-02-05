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

    public Map<String, Object> getServiceNameAndServiceMap() {
        Map<String, Object> serviceNameAndObjectMap = new HashMap<String, Object>();
        serviceNameAndObjectMap.put(armScoreService.getClass().getName(), armScoreService);
        serviceNameAndObjectMap.put(shoulderScoreService.getClass().getName(), shoulderScoreService);
        serviceNameAndObjectMap.put(chestScoreService.getClass().getName(), chestScoreService);
        serviceNameAndObjectMap.put(backScoreService.getClass().getName(), backScoreService);
        serviceNameAndObjectMap.put(legScoreService.getClass().getName(), legScoreService);
        return serviceNameAndObjectMap;
    }

    public Map<String, String> getServiceNameAndGetterMap() {
        Map<String, String> serviceNameAndGetterMap = new HashMap<String, String>();
        serviceNameAndGetterMap.put(armScoreService.getClass().getName(), "getExerciseArmScore");
        serviceNameAndGetterMap.put(shoulderScoreService.getClass().getName(), "getExerciseShoulderScore");
        serviceNameAndGetterMap.put(chestScoreService.getClass().getName(), "getExerciseChestScore");
        serviceNameAndGetterMap.put(backScoreService.getClass().getName(), "getExerciseBackScore");
        serviceNameAndGetterMap.put(legScoreService.getClass().getName(), "getExerciseLegScore");
        return serviceNameAndGetterMap;
    }


    public List<ExerciseEntity> getExercisesForMuscleGroup(double exerciseScoreGoal, Integer exerciseCountGoal, List<String> allExerciseShortNames, String serviceClassName, String entityName, String getScoreMethod) {
        Map<String, String> serviceNameAndGetterMap = getServiceNameAndGetterMap();
        Map<String, Object> serviceNameAndServiceMap = getServiceNameAndServiceMap();
        List<ExerciseEntity> allExercises = getExercises();
        List<ExerciseEntity> exerciseListToReturn = new ArrayList<>();

        double scoreSoFar = 0;
        double scoreToAdd;
        //System.out.println("STARTING TO GET EXERCISES WITH SERVICE " + serviceClassName);

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
                exerciseListToReturn.add(currentExercise);
                try {
                    System.out.println("THIS LOOP REQUIRES THE FOLLOWING: \n" +
                            serviceClassName + " (currently string method arg) " +
                            getScoreMethod + " ( also currently string method arg) " +
                            entityName + " ( also also currently string method arg) " +
                            serviceNameAndGetterMap.get(serviceClassName) + " (currently string in map)" +
                            serviceNameAndServiceMap.get(serviceClassName) + " (currently service in map) ");

                    for ( Method methods : Class.forName(serviceClassName).getDeclaredMethods() ) {
                        if (methods.toString().contains("get")) {
                            System.out.println(methods.toString());
                        }
                    }

                    Method entityMethod = Class.forName(serviceClassName).getDeclaredMethod(serviceNameAndGetterMap.get(serviceClassName), String.class);
                    Object entity = entityMethod.invoke(serviceNameAndServiceMap.get(serviceClassName), currentExerciseShortName);

                    Method method = Class.forName(serviceClassName).getDeclaredMethod(getScoreMethod, Class.forName(entityName));
                    scoreToAdd = (double) method.invoke(serviceNameAndServiceMap.get(serviceClassName), entity);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                scoreSoFar = sum(scoreSoFar, scoreToAdd);
            }
        }
        /*
        System.out.println("THE GOAL HAS BEEN REACHED BECAUSE WE GOT " + scoreSoFar + " SO FAR AND THE GOAL IS " + exerciseScoreGoal + " WITH ");
        for (ExerciseEntity exercise : exerciseListToReturn) {
            System.out.println(exercise.toString());
        }
         */

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
