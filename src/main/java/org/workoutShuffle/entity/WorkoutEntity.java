package org.workoutShuffle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="workouts_and_scores")
public class WorkoutEntity {
    @Id
    @Column(name = "workout_type")
    String workoutType;
    @Column(name = "workout_arm_score_goal")
    double workoutArmGoal;
    @Column(name = "workout_chest_score_goal")
    double workoutChestGoal;
    @Column(name = "workout_back_score_goal")
    double workoutBackGoal;
    @Column(name = "workout_legs_score_goal")
    double workoutLegsGoal;
    @Column(name = "workout_shoulder_score_goal")
    double workoutShoulderGoal;

    public WorkoutEntity() {
    }

    public WorkoutEntity(String workoutType, double workoutArmGoal, double workoutChestGoal, double workoutBackGoal, double workoutLegsGoal, double workoutShoulderGoal) {
        this.workoutType = workoutType;
        this.workoutArmGoal = workoutArmGoal;
        this.workoutChestGoal = workoutChestGoal;
        this.workoutBackGoal = workoutBackGoal;
        this.workoutLegsGoal = workoutLegsGoal;
        this.workoutShoulderGoal = workoutShoulderGoal;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public double getWorkoutArmGoal() {
        return workoutArmGoal;
    }

    public void setWorkoutArmGoal(double workoutArmGoal) {
        this.workoutArmGoal = workoutArmGoal;
    }

    public double getWorkoutChestGoal() {
        return workoutChestGoal;
    }

    public void setWorkoutChestGoal(double workoutChestGoal) {
        this.workoutChestGoal = workoutChestGoal;
    }

    public double getWorkoutBackGoal() {
        return workoutBackGoal;
    }

    public void setWorkoutBackGoal(double workoutBackGoal) {
        this.workoutBackGoal = workoutBackGoal;
    }

    public double getWorkoutLegsGoal() {
        return workoutLegsGoal;
    }

    public void setWorkoutLegsGoal(double workoutLegsGoal) {
        this.workoutLegsGoal = workoutLegsGoal;
    }

    public double getWorkoutShoulderGoal() {
        return workoutShoulderGoal;
    }

    public void setWorkoutShoulderGoal(double workoutShoulderGoal) {
        this.workoutShoulderGoal = workoutShoulderGoal;
    }

    @Override
    public String toString() {
        return "WorkoutEntity{" +
                "workoutType='" + workoutType + '\'' +
                ", workoutArmGoal=" + workoutArmGoal +
                ", workoutChestGoal=" + workoutChestGoal +
                ", workoutBackGoal=" + workoutBackGoal +
                ", workoutLegsGoal=" + workoutLegsGoal +
                ", workoutShoulderGoal=" + workoutShoulderGoal +
                '}';
    }
}
