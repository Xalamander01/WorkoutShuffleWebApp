package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="exercise_legs_scores")
public class ExerciseLegScoreEntity {
    @Id
    @Column(name="exercise_short_name")
    private String exerciseShortName;
    @Column(name="exercise_glute_max_scores")
    private double exerciseGluteMaxScore;
    @Column(name="exercise_glute_med_scores")
    private double exerciseGluteMedScore;
    @Column(name="exercise_hamstring_scores")
    private double exerciseHamstringScore;
    @Column(name="exercise_upper_quad_scores")
    private double exerciseUpperQuadScore;
    @Column(name="exercise_lower_quad_scores")
    private double exerciseLowerQuadScore;
    @Column(name="exercise_calf_scores")
    private double exerciseCalfScore;

    public ExerciseLegScoreEntity() {}

    public ExerciseLegScoreEntity(String exerciseShortName, double exerciseGluteMaxScore, double exerciseGluteMedScore, double exerciseHamstringScore, double exerciseUpperQuadScore, double exerciseLowerQuadScore, double exerciseCalfScore) {
        this.exerciseShortName = exerciseShortName;
        this.exerciseGluteMaxScore = exerciseGluteMaxScore;
        this.exerciseGluteMedScore = exerciseGluteMedScore;
        this.exerciseHamstringScore = exerciseHamstringScore;
        this.exerciseUpperQuadScore = exerciseUpperQuadScore;
        this.exerciseLowerQuadScore = exerciseLowerQuadScore;
        this.exerciseCalfScore = exerciseCalfScore;
    }

    public double getAverageScore() {
        return (this.exerciseGluteMaxScore+this.exerciseGluteMedScore+this.exerciseHamstringScore+this.exerciseUpperQuadScore+this.exerciseLowerQuadScore+this.exerciseCalfScore)/6;
    }
    public double getSumOfScore() {
        return (this.exerciseGluteMaxScore+this.exerciseGluteMedScore+this.exerciseHamstringScore+this.exerciseUpperQuadScore+this.exerciseLowerQuadScore+this.exerciseCalfScore);
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getExerciseGluteMaxScore() {
        return exerciseGluteMaxScore;
    }

    public void setExerciseGluteMaxScore(double exerciseGluteMaxScore) {
        this.exerciseGluteMaxScore = exerciseGluteMaxScore;
    }

    public double getExerciseGluteMedScore() {
        return exerciseGluteMedScore;
    }

    public void setExerciseGluteMedScore(double exerciseGluteMedScore) {
        this.exerciseGluteMedScore = exerciseGluteMedScore;
    }

    public double getExerciseHamstringScore() {
        return exerciseHamstringScore;
    }

    public void setExerciseHamstringScore(double exerciseHamstringScore) {
        this.exerciseHamstringScore = exerciseHamstringScore;
    }

    public double getExerciseUpperQuadScore() {
        return exerciseUpperQuadScore;
    }

    public void setExerciseUpperQuadScore(double exerciseUpperQuadScore) {
        this.exerciseUpperQuadScore = exerciseUpperQuadScore;
    }

    public double getExerciseLowerQuadScore() {
        return exerciseLowerQuadScore;
    }

    public void setExerciseLowerQuadScore(double exerciseLowerQuadScore) {
        this.exerciseLowerQuadScore = exerciseLowerQuadScore;
    }

    public double getExerciseCalfScore() {
        return exerciseCalfScore;
    }

    public void setExerciseCalfScore(double exerciseCalfScore) {
        this.exerciseCalfScore = exerciseCalfScore;
    }

    @Override
    public String toString() {
        return "ExerciseLegScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", exerciseGluteMaxScore=" + exerciseGluteMaxScore +
                ", exerciseGluteMedScore=" + exerciseGluteMedScore +
                ", exerciseHamstringScore=" + exerciseHamstringScore +
                ", exerciseUpperQuadScore=" + exerciseUpperQuadScore +
                ", exerciseLowerQuadScore=" + exerciseLowerQuadScore +
                ", exerciseCalfScore=" + exerciseCalfScore +
                '}';
    }
}
