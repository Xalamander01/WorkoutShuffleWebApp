package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_arm_scores")
public class ExerciseArmScoreEntity {
    @Id
    @Column(name = "exercise_short_name")
    private String exerciseShortName;
    @Column(name = "exercise_forearm_score")
    private double exerciseForearmScore;
    @Column(name = "exercise_inner_bi_score")
    private double exerciseInnerBiScore;
    @Column(name = "exercise_outer_bi_score")
    private double exerciseOuterBiScore;
    @Column(name = "exercise_long_tri_score")
    private double exerciseLongTriScore;
    @Column(name = "exercise_medial_tri_score")
    private double exerciseMedTriScore;
    @Column(name = "exercise_lat_tri_score")
    private double exerciseLatTriScore;

    public ExerciseArmScoreEntity() {
    }

    public ExerciseArmScoreEntity(String exerciseShortName, double exerciseForearmScore, double exerciseInnerBiScore, double exerciseOuterBiScore, double exerciseLongTriScore, double exerciseMedTriScore, double exerciseLatTriScore) {
        this.exerciseShortName = exerciseShortName;
        this.exerciseForearmScore = exerciseForearmScore;
        this.exerciseInnerBiScore = exerciseInnerBiScore;
        this.exerciseOuterBiScore = exerciseOuterBiScore;
        this.exerciseLongTriScore = exerciseLongTriScore;
        this.exerciseMedTriScore = exerciseMedTriScore;
        this.exerciseLatTriScore = exerciseLatTriScore;
    }

    public double getAverageScore() {
        return (this.exerciseForearmScore+this.exerciseInnerBiScore+this.exerciseOuterBiScore+this.exerciseLatTriScore+this.exerciseMedTriScore+exerciseLongTriScore)/6;
    }

    public double getSumOfScore() {
        return (this.exerciseForearmScore+this.exerciseInnerBiScore+this.exerciseOuterBiScore+this.exerciseLatTriScore+this.exerciseMedTriScore+exerciseLongTriScore);
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getExerciseForearmScore() {
        return exerciseForearmScore;
    }

    public void setExerciseForearmScore(double exerciseForearmScore) {
        this.exerciseForearmScore = exerciseForearmScore;
    }

    public double getExerciseInnerBiScore() {
        return exerciseInnerBiScore;
    }

    public void setExerciseInnerBiScore(double exerciseInnerBiScore) {
        this.exerciseInnerBiScore = exerciseInnerBiScore;
    }

    public double getExerciseOuterBiScore() {
        return exerciseOuterBiScore;
    }

    public void setExerciseOuterBiScore(double exerciseOuterBiScore) {
        this.exerciseOuterBiScore = exerciseOuterBiScore;
    }

    public double getExerciseLongTriScore() {
        return exerciseLongTriScore;
    }

    public void setExerciseLongTriScore(double exerciseLongTriScore) {
        this.exerciseLongTriScore = exerciseLongTriScore;
    }

    public double getExerciseMedTriScore() {
        return exerciseMedTriScore;
    }

    public void setExerciseMedTriScore(double exerciseMedTriScore) {
        this.exerciseMedTriScore = exerciseMedTriScore;
    }

    public double getExerciseLatTriScore() {
        return exerciseLatTriScore;
    }

    public void setExerciseLatTriScore(double exerciseLatTriScore) {
        this.exerciseLatTriScore = exerciseLatTriScore;
    }

    @Override
    public String toString() {
        return "ExerciseArmScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", exerciseForearmScore=" + exerciseForearmScore +
                ", exerciseInnerBiScore=" + exerciseInnerBiScore +
                ", exerciseOuterBiScore=" + exerciseOuterBiScore +
                ", exerciseLongTriScore=" + exerciseLongTriScore +
                ", exerciseMedTriScore=" + exerciseMedTriScore +
                ", exerciseLatTriScore=" + exerciseLatTriScore +
                '}';
    }
}
