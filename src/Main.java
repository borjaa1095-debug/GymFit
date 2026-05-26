import UsersAuth.User;
import UsersAuth.User;
import UsersAuth.Trainer;
import PlansWorkout.TrainingPlan;
import PlansWorkout.Workout;
import SessionPayment.ClassSession;
import SessionPayment.Payment;
import ForumIntegration.ForumPost;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String filePath = "Users.txt";

    // Login
    User u = new User("x", "x", 0, "x") {};
    boolean acceso = u.login(filePath);

    if (!acceso) {
        System.out.println("Acceso denegado.");
    }
    else
    {
        System.out.println("Acceso concedido. Bienvenido!");

        int opcion;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL - GYMFIT =====");
            System.out.println("1. Ver entrenamientos");
            System.out.println("2. Ver sesiones y pagos");
            System.out.println("3. Foro");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> menuEntrenamientos(sc);
                case 2 -> menuSesiones(sc);
                case 3 -> menuForo(sc);
                case 0 -> System.out.println("Hasta pronto!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
static void menuEntrenamientos(Scanner sc) {
    List<Workout> workouts = new ArrayList<>();
    workouts.add(new Workout("Cardio", "Correr 30 minutos", 30));
    workouts.add(new Workout("Fuerza", "Pesas y sentadillas", 45));
    TrainingPlan plan = new TrainingPlan("Pérdida de peso", workouts);

    System.out.println("\n--- Plan: " + plan.getGoal() + " ---");
    for (Workout w : plan.getWorkouts()) {
        w.displayWorkoutInfo();
        System.out.println();
    }
}

static void menuSesiones(Scanner sc) {
    // Persona 3 completará ClassSession y Payment con su lógica
    System.out.println("\n--- Sesiones y Pagos ---");
    System.out.println("(Pendiente de implementación por Persona 3)");
}

static void menuForo(Scanner sc) {
    List<ForumPost> posts = new ArrayList<>();
    posts.add(new ForumPost(1, "admin", "Bienvenidos", "Este es el foro de GymFit."));

    int opcion;
    do {
        System.out.println("\n--- FORO ---");
        System.out.println("1. Ver posts");
        System.out.println("2. Crear post");
        System.out.println("3. Comentar un post");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> {
                for (ForumPost p : posts) p.displayPost();
            }
            case 2 -> {
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                System.out.print("Contenido: ");
                String contenido = sc.nextLine();
                posts.add(new ForumPost(posts.size() + 1, "usuario", titulo, contenido));
                System.out.println("Post creado!");
            }
            case 3 -> {
                System.out.print("ID del post: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Comentario: ");
                String comentario = sc.nextLine();
                posts.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .ifPresentOrElse(
                                p -> {
                                    p.addComment(comentario);
                                    System.out.println("Comentario añadido.");
                                },
                                () -> System.out.println("Post no encontrado.")
                        );
            }
            case 0 -> {
            }
            default -> System.out.println("Opción no válida.");
        }
    } while (opcion != 0);
}


