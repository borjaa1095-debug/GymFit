package PlansWorkout;

public class Workout {
    String workoutName;
    String workoutDescription;
    int workoutDurationMin;

    public Workout(String workoutName, String workoutDescription, int workoutDurationMin) {
        this.workoutName = workoutName;
        this.workoutDescription = workoutDescription;
        this.workoutDurationMin = workoutDurationMin;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public void setWorkoutDescription(String workoutDescription) {
        this.workoutDescription = workoutDescription;
    }

    public int getWorkoutDurationMin() {
        return workoutDurationMin;
    }

    public void setWorkoutDurationMin(int workoutDurationMin) {
        this.workoutDurationMin = workoutDurationMin;
    }


    void displayWorkoutInfo() {
        System.out.println("Workout Name: " + workoutName);
        System.out.println("Description: " + workoutDescription);
        System.out.println("Duration (min): " + workoutDurationMin);
    }
}
