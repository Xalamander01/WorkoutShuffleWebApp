package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.LegScoreEntity;

@Repository
public interface LegScoreRepository extends CrudRepository<LegScoreEntity, String> {
}
