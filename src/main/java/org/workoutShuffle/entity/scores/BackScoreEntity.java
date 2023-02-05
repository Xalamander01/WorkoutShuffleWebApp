package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_back_scores")
public class BackScoreEntity {
    @Id
    @Column(name = "exercise_short_name")
    private String exerciseShortName;
    @Column(name = "exercise_upper_trap_scores")
    private double upperTrapScore;
    @Column(name = "exercise_lower_trap_scores")
    private double lowerTrapScore;
    @Column(name = "exercise_upper_lat_scores")
    private double upperLatScore;
    @Column(name = "exercise_lower_lat_scores")
    private double lowerLatScore;

    public BackScoreEntity() {
    }

    public BackScoreEntity(String exerciseShortName, double upperTrapScore, double lowerTrapScore, double upperLatScore, double lowerLatScore) {
        this.exerciseShortName = exerciseShortName;
        this.upperTrapScore = upperTrapScore;
        this.lowerTrapScore = lowerTrapScore;
        this.upperLatScore = upperLatScore;
        this.lowerLatScore = lowerLatScore;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getUpperTrapScore() {
        return upperTrapScore;
    }

    public void setUpperTrapScore(double upperTrapScore) {
        this.upperTrapScore = upperTrapScore;
    }

    public double getLowerTrapScore() {
        return lowerTrapScore;
    }

    public void setLowerTrapScore(double lowerTrapScore) {
        this.lowerTrapScore = lowerTrapScore;
    }

    public double getUpperLatScore() {
        return upperLatScore;
    }

    public void setUpperLatScore(double upperLatScore) {
        this.upperLatScore = upperLatScore;
    }

    public double getLowerLatScore() {
        return lowerLatScore;
    }

    public void setLowerLatScore(double lowerLatScore) {
        this.lowerLatScore = lowerLatScore;
    }

    @Override
    public String toString() {
        return "BackScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", upperTrapScore=" + upperTrapScore +
                ", lowerTrapScore=" + lowerTrapScore +
                ", upperLatScore=" + upperLatScore +
                ", lowerLatScore=" + lowerLatScore +
                '}';
    }
}
