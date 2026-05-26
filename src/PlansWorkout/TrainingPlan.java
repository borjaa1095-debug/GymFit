package PlansWorkout;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TrainingPlan {
    String goal;
    List<Workout> workouts;

    public TrainingPlan(String goal, List<Workout> workouts) {
        this.goal = goal;
        this.workouts = workouts;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/PlansWorkout/workouts.txt", true))) {
            printWriter.println(workout.getWorkoutName() + ", " + workout.getWorkoutDescription() + ", " + workout.getWorkoutDurationMin());
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
