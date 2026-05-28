package UsersAuth;

import PlansWorkout.TrainingPlan;
import PlansWorkout.Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trainer extends UserBase {

    public Trainer(String username, String password) {
        super(username, password);
    }

    public TrainingPlan createPlan() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the goal of the training plan:");
        String goal = sc.nextLine();

        // Empty list of workouts
        List<Workout> workouts = new ArrayList<>();

        // Create the plan
        TrainingPlan plan = new TrainingPlan(goal, workouts);

        System.out.println("How many workouts do you want to add?");
        int count = sc.nextInt();
        sc.nextLine(); // clear buffer

        for (int i = 0; i < count; i++) {
            System.out.println("\nWorkout " + (i + 1));

            System.out.print("Enter workout name: ");
            String name = sc.nextLine();

            System.out.print("Enter workout description: ");
            String description = sc.nextLine();

            System.out.print("Enter workout duration (minutes): ");
            int duration = sc.nextInt();
            sc.nextLine();

            // Create workout using your constructor
            Workout w = new Workout(goal, workouts, name, description, duration);

            // Add workout to plan (this also writes to workouts.txt)
            plan.addWorkout(w);

            System.out.println("Workout added!");
        }

        System.out.println("\nTraining plan created successfully!");
        return plan;
    }




}
