package org.workoutShuffle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.WorkoutEntity;

@Repository
public interface WorkoutRepository extends CrudRepository<WorkoutEntity, String> {
}
