package org.workoutShuffle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.UserEntity;

@Repository
public interface WorkoutSplitsRepository extends CrudRepository<UserEntity, Integer> {
}
