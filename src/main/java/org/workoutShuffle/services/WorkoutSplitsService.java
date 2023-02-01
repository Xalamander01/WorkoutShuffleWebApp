package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.UserEntity;
import org.workoutShuffle.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutSplitsService {

    @Autowired
    private WorkoutSplitsRepository workoutSplitsRepository;

    public List<WorkoutSplitsEntity> getUsers() {
        List<WorkoutSplitsEntity> workoutSplitsList = new ArrayList<>();
        for (WorkoutSplitsEntity workoutSplit : workoutSplitsRepository.findAll()) {
            workoutSplitsList.add(workoutSplit);
        }
        return workoutSplitsList;
    }

    public WorkoutSplitsEntity getWorkoutSplit(Integer workoutSplitId) {
        return workoutSplitsRepository.findById(workoutSplitId).get();
    }

    public void addWorkoutSplit(WorkoutSplitsEntity workoutSplitToAdd) {
        workoutSplitsRepository.save(workoutSplitToAdd);
    }

    public void updateWorkoutSplit(WorkoutSplitsEntity workoutSplitToUpdate) {
        workoutSplitsRepository.save(workoutSplitToUpdate);
    }

    public void deleteWorkoutSplit(Integer workoutSplitId) {
        workoutSplitsRepository.deleteById(workoutSplitId);
    }
}
