package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ExerciseArmScoreEntity;
@Repository
public interface ExerciseArmScoreRepository extends CrudRepository<ExerciseArmScoreEntity, String> {
}
