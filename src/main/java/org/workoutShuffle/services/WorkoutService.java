package org.workoutShuffle.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.repository.WorkoutRepository;
import org.workoutShuffle.repository.WorkoutSplitsRepository;
import org.workoutShuffle.services.scores.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private WorkoutSplitsService workoutSplitsService;
    @Autowired
    private ExerciseService exerciseService;
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
    @Autowired
    private WorkoutSplitsRepository workoutSplitsRepository;


    /* check if workouts map has been generated this session
       do not regenerate if it has been generated
       workouts map will be regenerated every time the page is refreshed if this step is skipped
     */
    public Map<String, List<ExerciseEntity>> checkForWorkoutsMap(HttpSession session, Integer workoutsPerWeek, Integer repetitionTolerance) {
        boolean foundWorkoutList = false;
        Map<String, List<ExerciseEntity>> workoutsMap = new HashMap<>();
        while (session.getAttributeNames().hasMoreElements()) {
            if (session.getAttributeNames().nextElement().equals("workoutsMap")) {
                foundWorkoutList = true;
                break;
            }
        }

        if (foundWorkoutList) {
            workoutsMap = (Map<String, List<ExerciseEntity>>) session.getAttribute("workoutsMap");
        }
        if (!foundWorkoutList || (foundWorkoutList && workoutsPerWeek != workoutsMap.keySet().size())) {
            workoutsMap = getWeeklyWorkoutsMap(workoutsPerWeek, repetitionTolerance);
            session.setAttribute("workoutsMap", workoutsMap);
            session.setMaxInactiveInterval(1800);
        }
        return workoutsMap;
    }

    /* generate a workout type string to exercises map
       if multiple workouts of the same type are needed, then change the key a bit
       this solution is not very elegant but it works for now */
    public Map<String, List<ExerciseEntity>> getWeeklyWorkoutsMap(Integer workoutsPerWeek, Integer repetitionTolerance) {
        Map<String, List<ExerciseEntity>> workoutsMap = new HashMap<>();
        List<String> workoutTypes = workoutSplitsService.getWeeklyWorkoutTypes(workoutsPerWeek, repetitionTolerance);
        for (String currentKey : workoutTypes) {
            String keyPreEdit = currentKey;
            while (workoutsMap.containsKey(currentKey)) {
                currentKey = currentKey + "a";
            }
            workoutsMap.put(currentKey, getExerciseList(keyPreEdit));
        }
        return workoutsMap;
    }

    /* transform workout type string to a string that is more pleasant to read
    * e.g. fullBody -> Full Body */
    public List<String> getWorkoutTypesForJSP(List<String> workoutTypes) {

        List<String> workoutTypesToReturn = new ArrayList<>();
        for (String workoutType : workoutTypes ){
            while (workoutType.endsWith("a")) {
                workoutType = workoutType.substring(0,workoutType.length()-1);
            }
            int stringLength = workoutType.length();
            for ( int i=0; i<stringLength; i++) {
                if ( i == 0 ) {
                    workoutType = workoutType.substring(i,1).toUpperCase() + workoutType.substring(1);
                } else if ( Character.isUpperCase(workoutType.charAt(i))) {
                    workoutType = workoutType.substring(0,i) + " " + workoutType.substring(i);
                    i++;
                }
                stringLength = workoutType.length();
            }
            workoutTypesToReturn.add(workoutType);
        }
        return workoutTypesToReturn;
    }

    /* generate a list of exercises ( a single workout ) of the required type */
    public List<ExerciseEntity> getExerciseList(String workoutType) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();
        System.out.println("WORKOUT TYPE IS " + workoutType);
        WorkoutEntity workoutEntity = this.getWorkout(workoutType);

        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutLegsPushGoal(), workoutEntity.getLegsPushExerciseCount(), legScoreService.getAllExerciseShortNames(), legScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.LegScoreEntity", "getPushScore", "getExerciseLegScore"));
        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutLegsPullGoal(), workoutEntity.getLegsPullExerciseCount(), legScoreService.getAllExerciseShortNames(), legScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.LegScoreEntity", "getPullScore", "getExerciseLegScore"));
        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutBackGoal(), workoutEntity.getBackExerciseCount(), backScoreService.getAllExerciseShortNames(), backScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.BackScoreEntity", "getAverageScore", "getExerciseBackScore"));
        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutChestGoal(), workoutEntity.getChestExerciseCount(), chestScoreService.getAllExerciseShortNames(), chestScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ChestScoreEntity", "getAverageScore", "getExerciseChestScore"));
        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutShoulderPushGoal(), workoutEntity.getShoulderPushExerciseCount(), shoulderScoreService.getAllExerciseShortNames(), shoulderScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ShoulderScoreEntity", "getPushScore", "getExerciseShoulderScore"));
        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutShoulderPullGoal(), workoutEntity.getShoulderPullExerciseCount(), shoulderScoreService.getAllExerciseShortNames(), shoulderScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ShoulderScoreEntity", "getPullScore", "getExerciseShoulderScore"));
        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutArmPushGoal(), workoutEntity.getArmPushExerciseCount(), armScoreService.getAllExerciseShortNames(), armScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ArmScoreEntity", "getPushScore", "getExerciseArmScore"));
        exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutArmPullGoal(), workoutEntity.getArmPullExerciseCount(), armScoreService.getAllExerciseShortNames(), armScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ArmScoreEntity", "getPullScore", "getExerciseArmScore"));

        return exerciseList;
    }

    // =================== crud methods below ===================
    public List<WorkoutEntity> getWorkouts() {
        List<WorkoutEntity> workoutList = new ArrayList<>();
        for (WorkoutEntity workout : workoutRepository.findAll()) {
            workoutList.add(workout);
        }
        return workoutList;
    }

    public WorkoutEntity getWorkout(String workoutType) {
        return workoutRepository.findById(workoutType).get();
    }

    public void addWorkout(WorkoutEntity workoutToAdd) {
        workoutRepository.save(workoutToAdd);
    }

    public void updateWorkout(WorkoutEntity workoutToUpdate) {
        workoutRepository.save(workoutToUpdate);
    }

    public void deleteWorkout(String workoutType) {
        workoutRepository.deleteById(workoutType);
    }
}
