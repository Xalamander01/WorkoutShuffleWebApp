package org.workoutShuffle.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.TypeAndWorkoutPair;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.repository.WorkoutRepository;
import org.workoutShuffle.repository.WorkoutSplitsRepository;
import org.workoutShuffle.services.scores.*;

import java.util.ArrayList;
import java.util.List;

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
    public List<TypeAndWorkoutPair> checkForWorkoutsList(HttpSession session, Integer workoutsPerWeek, Integer repetitionTolerance) {
        boolean foundWorkoutList = false;
        List<TypeAndWorkoutPair> typeWorkoutPairList = new ArrayList<>();
        List<ExerciseEntity> alreadyExercised = new ArrayList<>();

        while (session.getAttributeNames().hasMoreElements()) {
            if (session.getAttributeNames().nextElement().equals("typeWorkoutPairList")) {
                foundWorkoutList = true;
                break;
            }
        }

        if (foundWorkoutList) {
            typeWorkoutPairList = (List<TypeAndWorkoutPair>) session.getAttribute("typeWorkoutPairList");
            alreadyExercised = (List<ExerciseEntity>) session.getAttribute("alreadyExercised");
        }
        if (!foundWorkoutList || (foundWorkoutList && workoutsPerWeek != typeWorkoutPairList.size())) {
            Object[] temp = getWeeklyWorkoutsMap(workoutsPerWeek, repetitionTolerance, alreadyExercised);
            typeWorkoutPairList = (List<TypeAndWorkoutPair>) temp[0];
            alreadyExercised = (List<ExerciseEntity>) temp[1];
            session.setAttribute("typeWorkoutPairList", typeWorkoutPairList);
            session.setAttribute("alreadyExercised", alreadyExercised);
            session.setMaxInactiveInterval(1800);
        }
        return typeWorkoutPairList;
    }

    /* generate a workout type string to exercises map
       if multiple workouts of the same type are needed, then change the key a bit
       this solution is not very elegant but it works for now */
    public Object[] getWeeklyWorkoutsMap(Integer workoutsPerWeek, Integer repetitionTolerance, List<ExerciseEntity> alreadyExercised) {
        ArrayList<TypeAndWorkoutPair> typeWorkoutPairList = new ArrayList<>();
        List<ExerciseEntity> addToAlreadyExercised;
        List<ExerciseEntity> addToWorkoutsMap;
        List<String> workoutTypes = workoutSplitsService.getWeeklyWorkoutTypes(workoutsPerWeek, repetitionTolerance);
        for (String currentKey : workoutTypes) {
            Object[] temp = getExerciseList(currentKey, alreadyExercised);
            addToWorkoutsMap = (List<ExerciseEntity>) temp[0];
            addToAlreadyExercised = (List<ExerciseEntity>) temp[1];
            alreadyExercised.addAll(addToAlreadyExercised);
            typeWorkoutPairList.add(new TypeAndWorkoutPair(currentKey,addToWorkoutsMap));
        }
        return new Object[]{typeWorkoutPairList, alreadyExercised};
    }

    /* generate a list of exercises ( a single workout ) of the required type */
    public Object[] getExerciseList(String workoutType, List<ExerciseEntity> alreadyExercised) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();
        WorkoutEntity workoutEntity = this.getWorkout(workoutType);

        List<ExerciseEntity> legsPushExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutLegsPushGoal(), workoutEntity.getLegsPushExerciseCount(), legScoreService.getAllExerciseShortNames(), legScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.LegScoreEntity", "getPushScore", "getExerciseLegScore", alreadyExercised);
        alreadyExercised.addAll(legsPushExercises);
        List<ExerciseEntity> legsPullExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutLegsPullGoal(), workoutEntity.getLegsPullExerciseCount(), legScoreService.getAllExerciseShortNames(), legScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.LegScoreEntity", "getPullScore", "getExerciseLegScore", alreadyExercised);
        alreadyExercised.addAll(legsPullExercises);
        List<ExerciseEntity> chestExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutChestGoal(), workoutEntity.getChestExerciseCount(), chestScoreService.getAllExerciseShortNames(), chestScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ChestScoreEntity", "getAverageScore", "getExerciseChestScore", alreadyExercised);
        alreadyExercised.addAll(chestExercises);
        List<ExerciseEntity> backExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutBackGoal(), workoutEntity.getBackExerciseCount(), backScoreService.getAllExerciseShortNames(), backScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.BackScoreEntity", "getAverageScore", "getExerciseBackScore", alreadyExercised);
        alreadyExercised.addAll(backExercises);
        List<ExerciseEntity> shoulderPushExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutShoulderPushGoal(), workoutEntity.getShoulderPushExerciseCount(), shoulderScoreService.getAllExerciseShortNames(), shoulderScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ShoulderScoreEntity", "getPushScore", "getExerciseShoulderScore", alreadyExercised);
        alreadyExercised.addAll(shoulderPushExercises);
        List<ExerciseEntity> shoulderPullExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutShoulderPullGoal(), workoutEntity.getShoulderPullExerciseCount(), shoulderScoreService.getAllExerciseShortNames(), shoulderScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ShoulderScoreEntity", "getPullScore", "getExerciseShoulderScore", alreadyExercised);
        alreadyExercised.addAll(shoulderPullExercises);
        List<ExerciseEntity> armPushExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutArmPushGoal(), workoutEntity.getArmPushExerciseCount(), armScoreService.getAllExerciseShortNames(), armScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ArmScoreEntity", "getPushScore", "getExerciseArmScore", alreadyExercised);
        alreadyExercised.addAll(armPushExercises);
        List<ExerciseEntity> armPullExercises = exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutArmPullGoal(), workoutEntity.getArmPullExerciseCount(), armScoreService.getAllExerciseShortNames(), armScoreService.getClass().getName(), "org.workoutShuffle.entity.scores.ArmScoreEntity", "getPullScore", "getExerciseArmScore", alreadyExercised);
        alreadyExercised.addAll(armPullExercises);

        exerciseList.addAll(legsPushExercises);
        exerciseList.addAll(legsPullExercises);
        exerciseList.addAll(chestExercises);
        exerciseList.addAll(backExercises);
        exerciseList.addAll(shoulderPushExercises);
        exerciseList.addAll(shoulderPullExercises);
        exerciseList.addAll(armPushExercises);
        exerciseList.addAll(armPullExercises);

        return new Object[]{exerciseList,alreadyExercised};
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
