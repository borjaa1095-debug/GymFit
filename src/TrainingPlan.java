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

    void addWorkout(Workout workout) {
        workouts.add(workout);
    }
}
