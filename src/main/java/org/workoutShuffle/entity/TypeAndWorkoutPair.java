package org.workoutShuffle.entity;

import java.util.List;

public class TypeAndWorkoutPair {
    String workoutType;
    List<ExerciseEntity> exerciseList;

    public TypeAndWorkoutPair() {
    }

    public TypeAndWorkoutPair(String workoutType, List<ExerciseEntity> exerciseList) {
        this.workoutType = workoutType;
        this.exerciseList = exerciseList;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public List<ExerciseEntity> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<ExerciseEntity> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @Override
    public String toString() {
        return "TypeAndWorkoutPair{" +
                "workoutType='" + workoutType + '\'' +
                ", exerciseList=" + exerciseList +
                '}';
    }
}
