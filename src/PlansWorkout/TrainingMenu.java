package PlansWorkout;

import java.util.Scanner;

public class TrainingMenu {
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        Workout workout = null;
        TrainingPlan plan = null;
        int opc = 0;
        while (opc != 3) {
            System.out.println("Training Menu:");
            System.out.println("1. Create a new workout plan");
            System.out.println("2. View existing workout plans");
            System.out.println("3. Exit");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Creating a new training plan...");
                    System.out.println("Enter the workout name:");
                    String name = sc.nextLine();
                    System.out.println("Enter the workout description:");
                    String description = sc.nextLine();
                    System.out.println("Enter the workout duration in minutes:");
                    int duration = sc.nextInt();
                    System.out.println("Enter the training goal:");
                    String goal = sc.nextLine();
                    workout = new Workout(goal, null, name, description, duration);
                    plan = new TrainingPlan(goal, null);
                    plan.addWorkout(workout);
                    break;
                case 2:
                    System.out.println("Viewing existing training plans...");
                    workout.displayWorkoutInfo();
                    break;
                case 3:
                    System.out.println("Exiting the training menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
