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
    @Column(name = "legs_push_exercise_count")
    private Integer legsPushExerciseCount;
    @Column(name = "workout_legs_push_score_goal")
    private double workoutLegsPushGoal;
    @Column(name = "legs_pull_exercise_count")
    private Integer legsPullExerciseCount;
    @Column(name = "workout_legs_pull_score_goal")
    private double workoutLegsPullGoal;
    @Column(name = "back_exercise_count")
    private Integer backExerciseCount;
    @Column(name = "workout_back_score_goal")
    private double workoutBackGoal;
    @Column(name = "chest_exercise_count")
    private Integer chestExerciseCount;
    @Column(name = "workout_chest_score_goal")
    private double workoutChestGoal;
    @Column(name = "shoulder_push_exercise_count")
    private Integer shoulderPushExerciseCount;
    @Column(name = "workout_shoulder_push_score_goal")
    private double workoutShoulderPushGoal;
    @Column(name = "shoulder_pull_exercise_count")
    private Integer shoulderPullExerciseCount;
    @Column(name = "workout_shoulder_pull_score_goal")
    private double workoutShoulderPullGoal;
    @Column(name = "arm_push_exercise_count")
    private Integer armPushExerciseCount;
    @Column(name = "workout_arm_push_score_goal")
    private double workoutArmPushGoal;
    @Column(name = "arm_pull_exercise_count")
    private Integer armPullExerciseCount;
    @Column(name = "workout_arm_pull_score_goal")
    private double workoutArmPullGoal;

    public WorkoutEntity() {
    }

    public WorkoutEntity(String workoutType, Integer legsPushExerciseCount, double workoutLegsPushGoal, Integer legsPullExerciseCount, double workoutLegsPullGoal, Integer backExerciseCount, double workoutBackGoal, Integer chestExerciseCount, double workoutChestGoal, Integer shoulderPushExerciseCount, double workoutShoulderPushGoal, Integer shoulderPullExerciseCount, double workoutShoulderPullGoal, Integer armPushExerciseCount, double workoutArmPushGoal, Integer armPullExerciseCount, double workoutArmPullGoal) {
        this.workoutType = workoutType;
        this.legsPushExerciseCount = legsPushExerciseCount;
        this.workoutLegsPushGoal = workoutLegsPushGoal;
        this.legsPullExerciseCount = legsPullExerciseCount;
        this.workoutLegsPullGoal = workoutLegsPullGoal;
        this.backExerciseCount = backExerciseCount;
        this.workoutBackGoal = workoutBackGoal;
        this.chestExerciseCount = chestExerciseCount;
        this.workoutChestGoal = workoutChestGoal;
        this.shoulderPushExerciseCount = shoulderPushExerciseCount;
        this.workoutShoulderPushGoal = workoutShoulderPushGoal;
        this.shoulderPullExerciseCount = shoulderPullExerciseCount;
        this.workoutShoulderPullGoal = workoutShoulderPullGoal;
        this.armPushExerciseCount = armPushExerciseCount;
        this.workoutArmPushGoal = workoutArmPushGoal;
        this.armPullExerciseCount = armPullExerciseCount;
        this.workoutArmPullGoal = workoutArmPullGoal;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public Integer getLegsPushExerciseCount() {
        return legsPushExerciseCount;
    }

    public void setLegsPushExerciseCount(Integer legsPushExerciseCount) {
        this.legsPushExerciseCount = legsPushExerciseCount;
    }

    public double getWorkoutLegsPushGoal() {
        return workoutLegsPushGoal;
    }

    public void setWorkoutLegsPushGoal(double workoutLegsPushGoal) {
        this.workoutLegsPushGoal = workoutLegsPushGoal;
    }

    public Integer getLegsPullExerciseCount() {
        return legsPullExerciseCount;
    }

    public void setLegsPullExerciseCount(Integer legsPullExerciseCount) {
        this.legsPullExerciseCount = legsPullExerciseCount;
    }

    public double getWorkoutLegsPullGoal() {
        return workoutLegsPullGoal;
    }

    public void setWorkoutLegsPullGoal(double workoutLegsPullGoal) {
        this.workoutLegsPullGoal = workoutLegsPullGoal;
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

    public Integer getShoulderPushExerciseCount() {
        return shoulderPushExerciseCount;
    }

    public void setShoulderPushExerciseCount(Integer shoulderPushExerciseCount) {
        this.shoulderPushExerciseCount = shoulderPushExerciseCount;
    }

    public double getWorkoutShoulderPushGoal() {
        return workoutShoulderPushGoal;
    }

    public void setWorkoutShoulderPushGoal(double workoutShoulderPushGoal) {
        this.workoutShoulderPushGoal = workoutShoulderPushGoal;
    }

    public Integer getShoulderPullExerciseCount() {
        return shoulderPullExerciseCount;
    }

    public void setShoulderPullExerciseCount(Integer shoulderPullExerciseCount) {
        this.shoulderPullExerciseCount = shoulderPullExerciseCount;
    }

    public double getWorkoutShoulderPullGoal() {
        return workoutShoulderPullGoal;
    }

    public void setWorkoutShoulderPullGoal(double workoutShoulderPullGoal) {
        this.workoutShoulderPullGoal = workoutShoulderPullGoal;
    }

    public Integer getArmPushExerciseCount() {
        return armPushExerciseCount;
    }

    public void setArmPushExerciseCount(Integer armPushExerciseCount) {
        this.armPushExerciseCount = armPushExerciseCount;
    }

    public double getWorkoutArmPushGoal() {
        return workoutArmPushGoal;
    }

    public void setWorkoutArmPushGoal(double workoutArmPushGoal) {
        this.workoutArmPushGoal = workoutArmPushGoal;
    }

    public Integer getArmPullExerciseCount() {
        return armPullExerciseCount;
    }

    public void setArmPullExerciseCount(Integer armPullExerciseCount) {
        this.armPullExerciseCount = armPullExerciseCount;
    }

    public double getWorkoutArmPullGoal() {
        return workoutArmPullGoal;
    }

    public void setWorkoutArmPullGoal(double workoutArmPullGoal) {
        this.workoutArmPullGoal = workoutArmPullGoal;
    }

    @Override
    public String toString() {
        return "WorkoutEntity{" +
                "workoutType='" + workoutType + '\'' +
                ", legsPushExerciseCount=" + legsPushExerciseCount +
                ", workoutLegsPushGoal=" + workoutLegsPushGoal +
                ", legsPullExerciseCount=" + legsPullExerciseCount +
                ", workoutLegsPullGoal=" + workoutLegsPullGoal +
                ", backExerciseCount=" + backExerciseCount +
                ", workoutBackGoal=" + workoutBackGoal +
                ", chestExerciseCount=" + chestExerciseCount +
                ", workoutChestGoal=" + workoutChestGoal +
                ", shoulderPushExerciseCount=" + shoulderPushExerciseCount +
                ", workoutShoulderPushGoal=" + workoutShoulderPushGoal +
                ", shoulderPullExerciseCount=" + shoulderPullExerciseCount +
                ", workoutShoulderPullGoal=" + workoutShoulderPullGoal +
                ", armPushExerciseCount=" + armPushExerciseCount +
                ", workoutArmPushGoal=" + workoutArmPushGoal +
                ", armPullExerciseCount=" + armPullExerciseCount +
                ", workoutArmPullGoal=" + workoutArmPullGoal +
                '}';
    }
}
