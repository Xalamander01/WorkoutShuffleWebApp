package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.WorkoutSplitsEntity;
import org.workoutShuffle.repository.WorkoutSplitsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutSplitsService {

    @Autowired
    private WorkoutSplitsRepository workoutSplitsRepository;

    public List<WorkoutSplitsEntity> getWorkoutSplits() {
        List<WorkoutSplitsEntity> workoutSplitsList = new ArrayList<>();
        for (WorkoutSplitsEntity workoutSplit : workoutSplitsRepository.findAll()) {
            workoutSplitsList.add(workoutSplit);
        }
        return workoutSplitsList;
    }

    public WorkoutSplitsEntity getWorkoutSplit(String workoutSplit) {
        return workoutSplitsRepository.findById(workoutSplit).get();
    }

    public void addWorkoutSplit(WorkoutSplitsEntity workoutSplitToAdd) {
        workoutSplitsRepository.save(workoutSplitToAdd);
    }

    public void updateWorkoutSplit(WorkoutSplitsEntity workoutSplitToUpdate) {
        workoutSplitsRepository.save(workoutSplitToUpdate);
    }

    public void deleteWorkoutSplit(String workoutSplit) {
        workoutSplitsRepository.deleteById(workoutSplit);
    }
}
