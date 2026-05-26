package PlansWorkout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public void displayWorkoutInfo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/PlansWorkout/workouts.txt"))) {
            String linea;
            System.out.println("Workout Information");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
