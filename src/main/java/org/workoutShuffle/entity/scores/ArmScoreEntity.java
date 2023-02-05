package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_arm_scores")
public class ArmScoreEntity {
    @Id
    @Column(name = "exercise_short_name")
    private String exerciseShortName;
    @Column(name = "exercise_forearm_score")
    private double forearmScore;
    @Column(name = "exercise_inner_bi_score")
    private double innerBiScore;
    @Column(name = "exercise_outer_bi_score")
    private double outerBiScore;
    @Column(name = "exercise_long_tri_score")
    private double longTriScore;
    @Column(name = "exercise_medial_tri_score")
    private double medTriScore;
    @Column(name = "exercise_lat_tri_score")
    private double latTriScore;

    public ArmScoreEntity() {
    }

    public ArmScoreEntity(String exerciseShortName, double forearmScore, double innerBiScore, double outerBiScore, double longTriScore, double medTriScore, double latTriScore) {
        this.exerciseShortName = exerciseShortName;
        this.forearmScore = forearmScore;
        this.innerBiScore = innerBiScore;
        this.outerBiScore = outerBiScore;
        this.longTriScore = longTriScore;
        this.medTriScore = medTriScore;
        this.latTriScore = latTriScore;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getForearmScore() {
        return forearmScore;
    }

    public void setForearmScore(double forearmScore) {
        this.forearmScore = forearmScore;
    }

    public double getInnerBiScore() {
        return innerBiScore;
    }

    public void setInnerBiScore(double innerBiScore) {
        this.innerBiScore = innerBiScore;
    }

    public double getOuterBiScore() {
        return outerBiScore;
    }

    public void setOuterBiScore(double outerBiScore) {
        this.outerBiScore = outerBiScore;
    }

    public double getLongTriScore() {
        return longTriScore;
    }

    public void setLongTriScore(double longTriScore) {
        this.longTriScore = longTriScore;
    }

    public double getMedTriScore() {
        return medTriScore;
    }

    public void setMedTriScore(double medTriScore) {
        this.medTriScore = medTriScore;
    }

    public double getLatTriScore() {
        return latTriScore;
    }

    public void setLatTriScore(double latTriScore) {
        this.latTriScore = latTriScore;
    }

    @Override
    public String toString() {
        return "ArmScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", forearmScore=" + forearmScore +
                ", innerBiScore=" + innerBiScore +
                ", outerBiScore=" + outerBiScore +
                ", longTriScore=" + longTriScore +
                ", medTriScore=" + medTriScore +
                ", latTriScore=" + latTriScore +
                '}';
    }
}
