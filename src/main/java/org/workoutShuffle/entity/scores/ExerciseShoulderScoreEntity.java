package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="exercise_shoulder_scores")
public class ExerciseShoulderScoreEntity {
    @Id
    @Column(name="exercise_short_name")
    private String exerciseShortName;
    @Column(name="exercise_front_shoulder_score")
    private double exerciseFrontShoulderScore;
    @Column(name="exercise_side_shoulder_score")
    private double exerciseSideShoulderScore;
    @Column(name="exercise_rear_shoulder_score")
    private double exerciseRearShoulderScore;

    public ExerciseShoulderScoreEntity() {}

    public ExerciseShoulderScoreEntity(String exerciseShortName, double exerciseFrontShoulderScore, double exerciseSideShoulderScore, double exerciseRearShoulderScore) {
        this.exerciseShortName = exerciseShortName;
        this.exerciseFrontShoulderScore = exerciseFrontShoulderScore;
        this.exerciseSideShoulderScore = exerciseSideShoulderScore;
        this.exerciseRearShoulderScore = exerciseRearShoulderScore;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getExerciseFrontShoulderScore() {
        return exerciseFrontShoulderScore;
    }

    public void setExerciseFrontShoulderScore(double exerciseFrontShoulderScore) {
        this.exerciseFrontShoulderScore = exerciseFrontShoulderScore;
    }

    public double getExerciseSideShoulderScore() {
        return exerciseSideShoulderScore;
    }

    public void setExerciseSideShoulderScore(double exerciseSideShoulderScore) {
        this.exerciseSideShoulderScore = exerciseSideShoulderScore;
    }

    public double getExerciseRearShoulderScore() {
        return exerciseRearShoulderScore;
    }

    public void setExerciseRearShoulderScore(double exerciseRearShoulderScore) {
        this.exerciseRearShoulderScore = exerciseRearShoulderScore;
    }

    @Override
    public String toString() {
        return "ExerciseShoulderScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", exerciseFrontShoulderScore=" + exerciseFrontShoulderScore +
                ", exerciseSideShoulderScore=" + exerciseSideShoulderScore +
                ", exerciseRearShoulderScore=" + exerciseRearShoulderScore +
                '}';
    }
}
