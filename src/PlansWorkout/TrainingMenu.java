package PlansWorkout;

import java.util.Scanner;

public class TrainingMenu {
    public void displayMenu(boolean isTrainer) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        TrainingPlan lastPlan = null;

        while (opc != 3) {
            System.out.println("Training Menu:");
            System.out.println("1. Create a new workout plan");
            System.out.println("2. View existing workout plans");
            System.out.println("3. Exit");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    if(isTrainer)
                    {
                        System.out.println("Creating a new training plan...");
                        System.out.println("Enter the workout name:");
                        String name = sc.nextLine();
                        System.out.println("Enter the workout description:");
                        String description = sc.nextLine();
                        System.out.println("Enter the workout duration in minutes:");
                        int duration = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the training goal:");
                        String goal = sc.nextLine();

                        Workout workout = new Workout(name, description, duration);
                        lastPlan = new TrainingPlan(goal);
                        lastPlan.addWorkout(workout);
                        System.out.println("Plan saved!");
                        break;
                    }
                    else
                    {
                        System.out.println("Only trainers can create workout plans.");
                    }

                case 2:
                    System.out.println("Viewing existing training plans...");
                    Workout temp = new Workout("", "", 0);
                    temp.displayWorkoutInfo();
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
