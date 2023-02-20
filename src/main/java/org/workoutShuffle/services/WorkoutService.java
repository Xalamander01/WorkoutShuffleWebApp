package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.ExerciseEntity;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.repository.WorkoutRepository;
import org.workoutShuffle.services.scores.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;
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

    public List<ExerciseEntity> getExerciseList(String workoutType) {
        List<ExerciseEntity> exerciseList = new ArrayList<>();
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
}
