package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ExerciseChestScoreEntity;

@Repository
public interface ExerciseChestScoreRepository  extends CrudRepository<ExerciseChestScoreEntity, String> {
}
