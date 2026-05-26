import PlansWorkout.TrainingPlan;
import PlansWorkout.Workout;

public static void main(String[] args) {
    System.out.println("prueba super numero uno");

    //Pruebas Workouts
    TrainingPlan TrainingPlan = new TrainingPlan("Perder peso", new ArrayList<>());
    Workout workout1 = new Workout("Push-ups", "10 push-ups 3 series", 30);

    TrainingPlan.addWorkout(workout1);

    Workout Workout = new Workout("Push-ups", "10 push-ups 3 series", 30);

    Workout.displayWorkoutInfo();

}
