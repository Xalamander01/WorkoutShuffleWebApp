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
    private ExerciseArmScoreService exerciseArmScoreService;
    @Autowired
    private ExerciseShoulderScoreService exerciseShoulderScoreService;
    @Autowired
    private ExerciseChestScoreService exerciseChestScoreService;
    @Autowired
    private ExerciseBackScoreService exerciseBackScoreService;
    @Autowired
    private ExerciseLegScoreService exerciseLegScoreService;

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

        if ( workoutEntity.getWorkoutLegsGoal() > 0 ) {
            exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutLegsGoal(), workoutEntity.getLegsExerciseCount(), exerciseLegScoreService.getAllExerciseShortNames(), exerciseLegScoreService.getClass().getName()));
        }
        if ( workoutEntity.getWorkoutBackGoal() > 0 ) {
            exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutBackGoal(), workoutEntity.getBackExerciseCount(), exerciseBackScoreService.getAllExerciseShortNames(), exerciseBackScoreService.getClass().getName()));
        }
        if ( workoutEntity.getWorkoutChestGoal() > 0 ) {
            exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutChestGoal(), workoutEntity.getChestExerciseCount(), exerciseChestScoreService.getAllExerciseShortNames(), exerciseChestScoreService.getClass().getName()));
        }
        if ( workoutEntity.getWorkoutShoulderPushGoal() > 0 ) {
            exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutShoulderPushGoal(), workoutEntity.getShoulderPushExerciseCount(), exerciseShoulderScoreService.getAllExerciseShortNames(), exerciseShoulderScoreService.getClass().getName()));
        }
        if ( workoutEntity.getWorkoutShoulderPullGoal() > 0 ) {
            exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutShoulderPullGoal(), workoutEntity.getShoulderPullExerciseCount(), exerciseShoulderScoreService.getAllExerciseShortNames(), exerciseShoulderScoreService.getClass().getName()));
        }
        if ( workoutEntity.getWorkoutArmPushGoal() > 0 ) {
            exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutArmPushGoal(), workoutEntity.getArmPushExerciseCount(), exerciseArmScoreService.getAllExerciseShortNames(), exerciseArmScoreService.getClass().getName()));
        }
        if ( workoutEntity.getWorkoutArmPullGoal() > 0 ) {
            exerciseList.addAll(exerciseService.getExercisesForMuscleGroup(workoutEntity.getWorkoutArmPushGoal(), workoutEntity.getArmPushExerciseCount(), exerciseArmScoreService.getAllExerciseShortNames(), exerciseArmScoreService.getClass().getName()));
        }

        return exerciseList;
    }
}
