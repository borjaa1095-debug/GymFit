import PlansWorkout.TrainingPlan;
import PlansWorkout.Workout;

public static void main(String[] args) {
    System.out.println("prueba super numero uno");

    //Prueba rapida de la lista workourts
    TrainingPlan miPlan = new TrainingPlan("Prueba Rápida", new ArrayList<>());
    miPlan.addWorkout(new Workout("Push-ups", "3 series of 10 push-ups", 10));
    miPlan.addWorkout(new Workout("Pull-ups", "3 series of 10 pull-ups", 10));

    Workout miEjercicio = new Workout("Push-ups", "3 series of 10 push-ups", 10);
    miEjercicio.displayWorkoutInfo();
}
