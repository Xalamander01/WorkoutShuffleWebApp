package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="exercise_shoulder_scores")
public class ShoulderScoreEntity {
    @Id
    @Column(name="exercise_short_name")
    private String exerciseShortName;
    @Column(name="exercise_front_shoulder_score")
    private double frontShoulderScore;
    @Column(name="exercise_side_shoulder_score")
    private double sideShoulderScore;
    @Column(name="exercise_rear_shoulder_score")
    private double rearShoulderScore;

    public ShoulderScoreEntity() {}

    public ShoulderScoreEntity(String exerciseShortName, double frontShoulderScore, double sideShoulderScore, double rearShoulderScore) {
        this.exerciseShortName = exerciseShortName;
        this.frontShoulderScore = frontShoulderScore;
        this.sideShoulderScore = sideShoulderScore;
        this.rearShoulderScore = rearShoulderScore;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getFrontShoulderScore() {
        return frontShoulderScore;
    }

    public void setFrontShoulderScore(double frontShoulderScore) {
        this.frontShoulderScore = frontShoulderScore;
    }

    public double getSideShoulderScore() {
        return sideShoulderScore;
    }

    public void setSideShoulderScore(double sideShoulderScore) {
        this.sideShoulderScore = sideShoulderScore;
    }

    public double getRearShoulderScore() {
        return rearShoulderScore;
    }

    public void setRearShoulderScore(double rearShoulderScore) {
        this.rearShoulderScore = rearShoulderScore;
    }

    @Override
    public String toString() {
        return "ExerciseShoulderScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", exerciseFrontShoulderScore=" + frontShoulderScore +
                ", exerciseSideShoulderScore=" + sideShoulderScore +
                ", exerciseRearShoulderScore=" + rearShoulderScore +
                '}';
    }
}
