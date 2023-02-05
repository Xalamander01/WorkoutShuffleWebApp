package org.workoutShuffle.entity.scores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="exercise_legs_scores")
public class LegScoreEntity {
    @Id
    @Column(name="exercise_short_name")
    private String exerciseShortName;
    @Column(name="exercise_glute_max_scores")
    private double gluteMaxScore;
    @Column(name="exercise_glute_med_scores")
    private double gluteMedScore;
    @Column(name="exercise_hamstring_scores")
    private double hamstringScore;
    @Column(name="exercise_upper_quad_scores")
    private double upperQuadScore;
    @Column(name="exercise_lower_quad_scores")
    private double lowerQuadScore;
    @Column(name="exercise_calf_scores")
    private double calfScore;

    public LegScoreEntity() {}

    public LegScoreEntity(String exerciseShortName, double gluteMaxScore, double gluteMedScore, double hamstringScore, double upperQuadScore, double lowerQuadScore, double calfScore) {
        this.exerciseShortName = exerciseShortName;
        this.gluteMaxScore = gluteMaxScore;
        this.gluteMedScore = gluteMedScore;
        this.hamstringScore = hamstringScore;
        this.upperQuadScore = upperQuadScore;
        this.lowerQuadScore = lowerQuadScore;
        this.calfScore = calfScore;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public double getGluteMaxScore() {
        return gluteMaxScore;
    }

    public void setGluteMaxScore(double gluteMaxScore) {
        this.gluteMaxScore = gluteMaxScore;
    }

    public double getGluteMedScore() {
        return gluteMedScore;
    }

    public void setGluteMedScore(double gluteMedScore) {
        this.gluteMedScore = gluteMedScore;
    }

    public double getHamstringScore() {
        return hamstringScore;
    }

    public void setHamstringScore(double hamstringScore) {
        this.hamstringScore = hamstringScore;
    }

    public double getUpperQuadScore() {
        return upperQuadScore;
    }

    public void setUpperQuadScore(double upperQuadScore) {
        this.upperQuadScore = upperQuadScore;
    }

    public double getLowerQuadScore() {
        return lowerQuadScore;
    }

    public void setLowerQuadScore(double lowerQuadScore) {
        this.lowerQuadScore = lowerQuadScore;
    }

    public double getCalfScore() {
        return calfScore;
    }

    public void setCalfScore(double calfScore) {
        this.calfScore = calfScore;
    }

    @Override
    public String toString() {
        return "LegScoreEntity{" +
                "exerciseShortName='" + exerciseShortName + '\'' +
                ", gluteMaxScore=" + gluteMaxScore +
                ", gluteMedScore=" + gluteMedScore +
                ", hamstringScore=" + hamstringScore +
                ", upperQuadScore=" + upperQuadScore +
                ", lowerQuadScore=" + lowerQuadScore +
                ", calfScore=" + calfScore +
                '}';
    }
}
