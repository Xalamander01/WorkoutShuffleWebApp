package org.workoutShuffle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts_and_scores")
public class WorkoutEntity {
    @Id
    @Column(name = "workout_type")
    private String workoutType;
    @Column(name = "legs_exercise_count")
    private Integer legsExerciseCount;
    @Column(name = "workout_legs_score_goal")
    private double workoutLegsGoal;
    @Column(name = "back_exercise_count")
    private Integer backExerciseCount;
    @Column(name = "workout_back_score_goal")
    private double workoutBackGoal;
    @Column(name = "chest_exercise_count")
    private Integer chestExerciseCount;
    @Column(name = "workout_chest_score_goal")
    private double workoutChestGoal;
    @Column(name = "shoulder_exercise_count")
    private Integer shoulderExerciseCount;
    @Column(name = "workout_shoulder_score_goal")
    private double workoutShoulderGoal;
    @Column(name = "arm_exercise_count")
    private Integer armExerciseCount;
    @Column(name = "workout_arm_score_goal")
    private double workoutArmGoal;

    public WorkoutEntity() {
    }

    public WorkoutEntity(String workoutType, Integer legsExerciseCount, double workoutLegsGoal, Integer backExerciseCount, double workoutBackGoal, Integer chestExerciseCount, double workoutChestGoal, Integer shoulderExerciseCount, double workoutShoulderGoal, Integer armExerciseCount, double workoutArmGoal) {
        this.workoutType = workoutType;
        this.legsExerciseCount = legsExerciseCount;
        this.workoutLegsGoal = workoutLegsGoal;
        this.backExerciseCount = backExerciseCount;
        this.workoutBackGoal = workoutBackGoal;
        this.chestExerciseCount = chestExerciseCount;
        this.workoutChestGoal = workoutChestGoal;
        this.shoulderExerciseCount = shoulderExerciseCount;
        this.workoutShoulderGoal = workoutShoulderGoal;
        this.armExerciseCount = armExerciseCount;
        this.workoutArmGoal = workoutArmGoal;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public Integer getLegsExerciseCount() {
        return legsExerciseCount;
    }

    public void setLegsExerciseCount(Integer legsExerciseCount) {
        this.legsExerciseCount = legsExerciseCount;
    }

    public double getWorkoutLegsGoal() {
        return workoutLegsGoal;
    }

    public void setWorkoutLegsGoal(double workoutLegsGoal) {
        this.workoutLegsGoal = workoutLegsGoal;
    }

    public Integer getBackExerciseCount() {
        return backExerciseCount;
    }

    public void setBackExerciseCount(Integer backExerciseCount) {
        this.backExerciseCount = backExerciseCount;
    }

    public double getWorkoutBackGoal() {
        return workoutBackGoal;
    }

    public void setWorkoutBackGoal(double workoutBackGoal) {
        this.workoutBackGoal = workoutBackGoal;
    }

    public Integer getChestExerciseCount() {
        return chestExerciseCount;
    }

    public void setChestExerciseCount(Integer chestExerciseCount) {
        this.chestExerciseCount = chestExerciseCount;
    }

    public double getWorkoutChestGoal() {
        return workoutChestGoal;
    }

    public void setWorkoutChestGoal(double workoutChestGoal) {
        this.workoutChestGoal = workoutChestGoal;
    }

    public Integer getShoulderExerciseCount() {
        return shoulderExerciseCount;
    }

    public void setShoulderExerciseCount(Integer shoulderExerciseCount) {
        this.shoulderExerciseCount = shoulderExerciseCount;
    }

    public double getWorkoutShoulderGoal() {
        return workoutShoulderGoal;
    }

    public void setWorkoutShoulderGoal(double workoutShoulderGoal) {
        this.workoutShoulderGoal = workoutShoulderGoal;
    }

    public Integer getArmExerciseCount() {
        return armExerciseCount;
    }

    public void setArmExerciseCount(Integer armExerciseCount) {
        this.armExerciseCount = armExerciseCount;
    }

    public double getWorkoutArmGoal() {
        return workoutArmGoal;
    }

    public void setWorkoutArmGoal(double workoutArmGoal) {
        this.workoutArmGoal = workoutArmGoal;
    }

    @Override
    public String toString() {
        return "WorkoutEntity{" +
                "workoutType='" + workoutType + '\'' +
                ", legsExerciseCount=" + legsExerciseCount +
                ", workoutLegsGoal=" + workoutLegsGoal +
                ", backExerciseCount=" + backExerciseCount +
                ", workoutBackGoal=" + workoutBackGoal +
                ", chestExerciseCount=" + chestExerciseCount +
                ", workoutChestGoal=" + workoutChestGoal +
                ", shoulderExerciseCount=" + shoulderExerciseCount +
                ", workoutShoulderGoal=" + workoutShoulderGoal +
                ", armExerciseCount=" + armExerciseCount +
                ", workoutArmGoal=" + workoutArmGoal +
                '}';
    }
}
