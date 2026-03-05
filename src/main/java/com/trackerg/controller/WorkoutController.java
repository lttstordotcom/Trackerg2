package com.trackerg.controller;

import com.trackerg.model.Workout;
import com.trackerg.service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    // home page route
    @GetMapping("/")
    public String showHome() {
        return "index";
    }

    // show list of workouts
    @GetMapping("/workouts")
    public String showWorkouts(Model model) {
        model.addAttribute("workouts", workoutService.getAllWorkouts());
        return "workouts";
    }

    @GetMapping("/workouts/new")
    public String showAddForm(Model model) {
        model.addAttribute("workout", new Workout());
        return "addWorkout";
    }

    // save workout then go back to list
    @PostMapping("/workouts")
    public String addWorkout(@Valid @ModelAttribute Workout workout, BindingResult result) {
        if (result.hasErrors()) {
            return "addWorkout";
        }

        workoutService.saveWorkout(workout);
        return "redirect:/workouts";
    }
}
