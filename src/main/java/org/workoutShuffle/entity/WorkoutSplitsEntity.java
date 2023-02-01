package org.workoutShuffle.entity;

@Entity
@Table="workout_splits"
public class WorkoutSplitsEntity {
  
  @Id
  @Column(name="split_id")
  Integer splitId;
  @Column(name="workout_split")
  String workoutSplit;
  @Column(name="workouts_per_week")
  Integer workoutsPerWeek;
  @Column(name="types_of_workouts")
  String typesOfWorkouts;
  
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
    this.typesOfWorkouts = typesOfWorkouts
  }
}
