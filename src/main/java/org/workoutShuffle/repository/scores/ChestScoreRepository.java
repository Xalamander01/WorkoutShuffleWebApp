package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ChestScoreEntity;

@Repository
public interface ChestScoreRepository extends CrudRepository<ChestScoreEntity, String> {
}
