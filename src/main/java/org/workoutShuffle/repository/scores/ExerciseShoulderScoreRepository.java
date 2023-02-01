package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ExerciseShoulderScoreEntity;

@Repository
public interface ExerciseShoulderScoreRepository extends CrudRepository<ExerciseShoulderScoreEntity, String> {
}
