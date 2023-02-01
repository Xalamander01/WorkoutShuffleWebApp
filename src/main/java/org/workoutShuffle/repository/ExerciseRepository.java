package org.workoutShuffle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.ExerciseEntity;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseEntity, String> {
}
