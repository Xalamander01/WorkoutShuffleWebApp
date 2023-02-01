package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ExerciseBackScoreEntity;

@Repository
public interface ExerciseBackScoreRepository extends CrudRepository<ExerciseBackScoreEntity, String> {
}
