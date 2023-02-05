package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_chest_scores")
public class ChestScoreEntity {
    @Id
    @Column(name = "exercise_short_name")
    private String exerciseShortName;
    @Column(name = "exercise_upper_pec_scores")
    private double upperPecScore;
    @Column(name = "exercise_middle_pec_scores")
    private double middlePecScore;
    @Column(name = "exercise_lower_pec_scores")
    private double lowerPecScore;

    public ChestScoreEntity() {
    }

    public ChestScoreEntity(String exerciseShortName, double upperPecScore, double middlePecScore, double lowerPecScore) {
        this.exerciseShortName = exerciseShortName;
        this.upperPecScore = upperPecScore;
        this.middlePecScore = middlePecScore;
        this.lowerPecScore = lowerPecScore;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getUpperPecScore() {
        return upperPecScore;
    }

    public void setUpperPecScore(double upperPecScore) {
        this.upperPecScore = upperPecScore;
    }

    public double getMiddlePecScore() {
        return middlePecScore;
    }

    public void setMiddlePecScore(double middlePecScore) {
        this.middlePecScore = middlePecScore;
    }

    public double getLowerPecScore() {
        return lowerPecScore;
    }

    public void setLowerPecScore(double lowerPecScore) {
        this.lowerPecScore = lowerPecScore;
    }

    @Override
    public String toString() {
        return "ChestScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", upperPecScore=" + upperPecScore +
                ", middlePecScore=" + middlePecScore +
                ", lowerPecScore=" + lowerPecScore +
                '}';
    }
}
