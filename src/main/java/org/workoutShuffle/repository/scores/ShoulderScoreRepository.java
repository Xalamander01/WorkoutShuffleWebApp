package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ShoulderScoreEntity;

@Repository
public interface ShoulderScoreRepository extends CrudRepository<ShoulderScoreEntity, String> {
}
