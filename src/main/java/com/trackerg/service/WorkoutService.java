package com.trackerg.service;

import com.trackerg.model.Workout;
import com.trackerg.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAllByOrderByWorkoutDateDesc();
    }

    // save one workout from form input
    public void saveWorkout(Workout workout) {
        workoutRepository.save(workout);
    }
}
