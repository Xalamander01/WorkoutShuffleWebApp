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

        exerciseList.addAll(exerciseLegScoreService.getLegExercisesForWorkout(workoutEntity.getWorkoutLegsGoal(), workoutEntity.getLegsExerciseCount()));
        exerciseList.addAll(exerciseBackScoreService.getBackExercisesForWorkout(workoutEntity.getWorkoutBackGoal(), workoutEntity.getBackExerciseCount()));
        exerciseList.addAll(exerciseChestScoreService.getChestExercisesForWorkout(workoutEntity.getWorkoutChestGoal(), workoutEntity.getChestExerciseCount()));
        exerciseList.addAll(exerciseShoulderScoreService.getShoulderExercisesForWorkout(workoutEntity.getWorkoutShoulderGoal(), workoutEntity.getShoulderExerciseCount()));
        System.out.println("TRYING TO ACHIEVE " + workoutEntity.getWorkoutArmGoal() + " SCORE WITH " + workoutEntity.getArmExerciseCount() + " EXERCISES");
        exerciseList.addAll(exerciseArmScoreService.getArmExercisesForWorkout(workoutEntity.getWorkoutArmGoal(), workoutEntity.getArmExerciseCount()));

        return exerciseList;
    }
}
