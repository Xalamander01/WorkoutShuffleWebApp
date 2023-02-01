package org.workoutShuffle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.WorkoutSplitsEntity;

@Repository
public interface WorkoutSplitsRepository extends CrudRepository<WorkoutSplitsEntity, String> {
}
