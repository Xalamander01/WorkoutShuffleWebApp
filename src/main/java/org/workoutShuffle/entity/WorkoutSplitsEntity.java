package org.workoutShuffle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="workout_splits")
public class WorkoutSplitsEntity {
  
  @Id
  @Column(name="workout_split")
  private String workoutSplit;
  @Column(name="workouts_per_week")
  private Integer workoutsPerWeek;
  @Column(name="types_of_workouts")
  private String typesOfWorkouts;
  
  public WorkoutSplitsEntity() {}
  public WorkoutSplitsEntity(String workoutSplit, Integer workoutsPerWeek, String typesOfWorkouts) {
    this.workoutSplit = workoutSplit;
    this.workoutsPerWeek = workoutsPerWeek;
    this.typesOfWorkouts = typesOfWorkouts;
  }
  
  public String getWorkoutSplit() {
    return workoutSplit;
  }
  public void setWorkoutSplit(String workoutSplit) {
    this.workoutSplit = workoutSplit;
  }
  public Integer getWorkoutsPerWeek() {
    return workoutsPerWeek;
  }
  public void setWorkoutsPerWeek(Integer workoutsPerWeek) {
    this.workoutsPerWeek = workoutsPerWeek;
  }
  public String getTypesOfWorkouts() {
    return typesOfWorkouts;
  }
  public void setTypesOfWorkouts(String typesOfWorkouts) {
    this.typesOfWorkouts = typesOfWorkouts;
  }
}
