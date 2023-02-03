package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_chest_scores")
public class ExerciseChestScoreEntity {
    @Id
    @Column(name = "exercise_short_name")
    private String exerciseShortName;
    @Column(name = "exercise_upper_pec_scores")
    private double exerciseUpperPecScore;
    @Column(name = "exercise_middle_pec_scores")
    private double exerciseMiddlePecScore;
    @Column(name = "exercise_lower_pec_scores")
    private double exerciseLowerPecScore;

    public ExerciseChestScoreEntity() {
    }

    public ExerciseChestScoreEntity(String exerciseShortName, double exerciseUpperPecScore, double exerciseMiddlePecScore, double exerciseLowerPecScore) {
        this.exerciseShortName = exerciseShortName;
        this.exerciseUpperPecScore = exerciseUpperPecScore;
        this.exerciseMiddlePecScore = exerciseMiddlePecScore;
        this.exerciseLowerPecScore = exerciseLowerPecScore;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getExerciseUpperPecScore() {
        return exerciseUpperPecScore;
    }

    public void setExerciseUpperPecScore(double exerciseUpperPecScore) {
        this.exerciseUpperPecScore = exerciseUpperPecScore;
    }

    public double getExerciseMiddlePecScore() {
        return exerciseMiddlePecScore;
    }

    public void setExerciseMiddlePecScore(double exerciseMiddlePecScore) {
        this.exerciseMiddlePecScore = exerciseMiddlePecScore;
    }

    public double getExerciseLowerPecScore() {
        return exerciseLowerPecScore;
    }

    public void setExerciseLowerPecScore(double exerciseLowerPecScore) {
        this.exerciseLowerPecScore = exerciseLowerPecScore;
    }
}
