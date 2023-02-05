package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.ArmScoreEntity;
@Repository
public interface ArmScoreRepository extends CrudRepository<ArmScoreEntity, String> {
}
