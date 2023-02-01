package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.WorkoutEntity;
import org.workoutShuffle.repository.WorkoutRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<WorkoutEntity> getWorkouts() {
        List<WorkoutEntity> workoutList = new ArrayList<>();
        for (WorkoutEntity workout : workoutRepository.findAll()) {
            workoutList.add(workout);
        }
        return workoutList;
    }

    public WorkoutEntity getWorkout(String workoutType) {
        return workoutRepository.findById(workoutType).get();
    }

    public void addWorkout(WorkoutEntity workoutToAdd) {
        workoutRepository.save(workoutToAdd);
    }

    public void updateWorkout(WorkoutEntity workoutToUpdate) {
        workoutRepository.save(workoutToUpdate);
    }

    public void deleteWorkout(String workoutType) {
        workoutRepository.deleteById(workoutType);
    }
}
