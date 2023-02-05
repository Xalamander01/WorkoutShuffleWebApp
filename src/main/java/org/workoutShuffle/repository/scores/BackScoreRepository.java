package org.workoutShuffle.repository.scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workoutShuffle.entity.scores.BackScoreEntity;

@Repository
public interface BackScoreRepository extends CrudRepository<BackScoreEntity, String> {
}
