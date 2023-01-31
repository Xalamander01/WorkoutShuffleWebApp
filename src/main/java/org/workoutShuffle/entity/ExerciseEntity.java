package org.workoutShuffle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="exercise_dictionary")
public class ExerciseEntity {
    @Id
    @Column(name="exercise_short_name")
    String exerciseShortName;
    @Column(name="exercise_long_name")
    String exerciseLongName;
    @Column(name="exercise_description")
    String exerciseDescription;

    public ExerciseEntity() {
    }

    public ExerciseEntity(String exerciseShortName, String exerciseLongName, String exerciseDescription) {
        this.exerciseShortName = exerciseShortName;
        this.exerciseLongName = exerciseLongName;
        this.exerciseDescription = exerciseDescription;
    }

    public String getExerciseShortName() {
        return exerciseShortName;
    }

    public void setExerciseShortName(String exerciseShortName) {
        this.exerciseShortName = exerciseShortName;
    }

    public String getExerciseLongName() {
        return exerciseLongName;
    }

    public void setExerciseLongName(String exerciseLongName) {
        this.exerciseLongName = exerciseLongName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }
}
