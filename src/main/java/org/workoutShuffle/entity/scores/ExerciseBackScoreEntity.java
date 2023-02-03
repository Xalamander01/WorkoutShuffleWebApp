package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_back_scores")
public class ExerciseBackScoreEntity {
    @Id
    @Column(name = "exercise_short_name")
    private String exerciseShortName;
    @Column(name = "exercise_upper_trap_scores")
    private double exerciseUpperTrapScore;
    @Column(name = "exercise_lower_trap_scores")
    private double exerciseLowerTrapScore;
    @Column(name = "exercise_upper_lat_scores")
    private double exerciseUpperLatScore;
    @Column(name = "exercise_lower_lat_scores")
    private double exerciseLowerLatScore;

    public ExerciseBackScoreEntity() {
    }

    public ExerciseBackScoreEntity(String exerciseShortName, double exerciseUpperTrapScore, double exerciseLowerTrapScore, double exerciseUpperLatScore, double exerciseLowerLatScore) {
        this.exerciseShortName = exerciseShortName;
        this.exerciseUpperTrapScore = exerciseUpperTrapScore;
        this.exerciseLowerTrapScore = exerciseLowerTrapScore;
        this.exerciseUpperLatScore = exerciseUpperLatScore;
        this.exerciseLowerLatScore = exerciseLowerLatScore;
    }

    public double getAverageScore() {
        return (this.exerciseUpperTrapScore + this.exerciseLowerTrapScore + this.exerciseUpperLatScore + this.exerciseLowerLatScore) / 4;
    }
    public double getSumOfScore() {
        return (this.exerciseUpperTrapScore + this.exerciseLowerTrapScore + this.exerciseUpperLatScore + this.exerciseLowerLatScore);
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getExerciseUpperTrapScore() {
        return exerciseUpperTrapScore;
    }

    public void setExerciseUpperTrapScore(double exerciseUpperTrapScore) {
        this.exerciseUpperTrapScore = exerciseUpperTrapScore;
    }

    public double getExerciseLowerTrapScore() {
        return exerciseLowerTrapScore;
    }

    public void setExerciseLowerTrapScore(double exerciseLowerTrapScore) {
        this.exerciseLowerTrapScore = exerciseLowerTrapScore;
    }

    public double getExerciseUpperLatScore() {
        return exerciseUpperLatScore;
    }

    public void setExerciseUpperLatScore(double exerciseUpperLatScore) {
        this.exerciseUpperLatScore = exerciseUpperLatScore;
    }

    public double getExerciseLowerLatScore() {
        return exerciseLowerLatScore;
    }

    public void setExerciseLowerLatScore(double exerciseLowerLatScore) {
        this.exerciseLowerLatScore = exerciseLowerLatScore;
    }

    @Override
    public String toString() {
        return "ExerciseBackScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", exerciseUpperTrapScore='" + exerciseUpperTrapScore + '\'' +
                ", exerciseLowerTrapScore='" + exerciseLowerTrapScore + '\'' +
                ", exerciseUpperLatScore='" + exerciseUpperLatScore + '\'' +
                ", exerciseLowerLatScore='" + exerciseLowerLatScore + '\'' +
                '}';
    }
}
