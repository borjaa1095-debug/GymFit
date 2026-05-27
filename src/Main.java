import PlansWorkout.TrainingMenu;
import UsersAuth.User;
import ForumIntegration.ForumPost;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String filePathUsers = "Users.txt";
    String filePathTrainers = "Trainers.txt";
    String ans = "";
    boolean isTrainer = false;
    System.out.println("Welcome to C Gym Fit!");


    while (ans == null || (!ans.equals("1") && !ans.equals("2"))) {

        System.out.println("Please enter your choice");
        System.out.println("1. Register");
        System.out.println("2. Login");
        ans = sc.nextLine();

        if (ans.equals("1")) {
            System.out.println("Please enter your username");
            String username = sc.nextLine();

            System.out.println("Please enter your password");
            String password = sc.nextLine();

            User newUser = new User(username, password);

            boolean registered = newUser.register(filePathUsers, filePathTrainers);

            if (registered) {
                System.out.println("Registration successful! You can now log in.");
            } else {
                System.out.println("Registration failed. Please try again.");
            }

            ans = null;
        }
        else if (ans.equals("2")) {

            User temp = new User("x", "x");

            if(temp.login(filePathUsers, filePathTrainers))
            {
                isTrainer = checkIfTrainer(temp.getUsername(), temp.getPassword(), filePathTrainers);
                System.out.println("Login successful! Welcome to Gym Fit.");
            }
            else
            {
                System.out.println("Login failed. Please check your credentials and try again.");
            }
        }
        else {
            System.out.println("Invalid input. Please enter 1 or 2.");
            ans = null;
        }
    }

        int opcion;
        do {
            System.out.println("===== MENÚ PRINCIPAL - GYMFIT =====");
            System.out.println("1. Ver entrenamientos");
            System.out.println("2. Ver sesiones y pagos");
            System.out.println("3. Foro");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> menuEntrenamientos(sc, isTrainer);
                case 2 -> menuSesiones(sc);
                case 3 -> menuForo(sc);
                case 0 -> System.out.println("Hasta pronto!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

static void menuEntrenamientos(Scanner sc, boolean isTrainer) {
    TrainingMenu tm = new TrainingMenu();
    tm.displayMenu(isTrainer);
}

private static boolean checkIfTrainer(String username, String password, String filePathTrainers) {
    boolean isTrainer = false;
    try (BufferedReader br = new BufferedReader(new FileReader(filePathTrainers))) {
        String line;
        while ((line = br.readLine()) != null && !isTrainer) {
            if (line.contains(username) && line.contains(password)) {
                isTrainer = true;
            }
        }
    } catch (IOException e) {
        System.out.println("Error");
    }
    return isTrainer;
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


