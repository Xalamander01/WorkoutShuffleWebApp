package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ExerciseLegScoreEntity;

@Repository
public interface ExerciseLegScoreRepository extends CrudRepository<ExerciseLegScoreEntity, String> {
}
