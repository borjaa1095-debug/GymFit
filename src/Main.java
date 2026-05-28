import PlansWorkout.TrainingMenu;
import UsersAuth.User;
import ForumIntegration.ForumPost;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import SessionPayment.SessionMenu;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String filePathUsers = "Users.txt";
        String filePathTrainers = "Trainers.txt";
        String ans = null;
        String userType = "none";

        System.out.println("Welcome to C Gym Fit!");

        while (ans == null || (!ans.equals("1") && !ans.equals("2"))) {

            System.out.println("Please enter your choice");
            System.out.println("1. Register");
            System.out.println("2. Login");
            ans = sc.nextLine();

            if (ans.equals("1")) {

                System.out.println("Enter your username");
                String username = sc.nextLine();

                System.out.println("Enter your password");
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

                userType = temp.login(filePathUsers, filePathTrainers);

                if (!userType.equals("none")) {
                    System.out.println("Login successful! Welcome to Gym Fit.");
                } else {
                    System.out.println("Login failed. Please check your credentials and try again.");
                    ans = null;
                }

            }
            else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                ans = null;
            }
        }

        int option;
        do {
            System.out.println("===== MAIN MENU - GYMFIT =====");
            System.out.println("1. View workouts");
            System.out.println("2. View sessions and payments");
            System.out.println("3. Forum");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> menuWorkouts(sc, userType.equals("trainer"));
                case 2 -> menuSessions(sc);
                case 3 -> menuForum(sc);
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    static void menuWorkouts(Scanner sc, boolean isTrainer) {
        TrainingMenu tm = new TrainingMenu();
        tm.displayMenu(isTrainer);
    }

    static void menuSessions(Scanner sc) {
        SessionMenu sessionMenu = new SessionMenu();
        sessionMenu.showMenu();
    }

    static void menuForum(Scanner sc) {
        List<ForumPost> posts = new ArrayList<>();
        posts.add(new ForumPost(1, "admin", "Welcome", "This is the GymFit forum."));

        int option;
        do {
            System.out.println("\n--- FORUM ---");
            System.out.println("1. View posts");
            System.out.println("2. Create post");
            System.out.println("3. Comment on a post");
            System.out.println("0. Back");
            System.out.print("Option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    for (ForumPost p : posts) p.displayPost();
                }
                case 2 -> {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Content: ");
                    String content = sc.nextLine();
                    posts.add(new ForumPost(posts.size() + 1, "user", title, content));
                    System.out.println("Post created!");
                }
                case 3 -> {
                    System.out.print("Post ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Comment: ");
                    String comment = sc.nextLine();
                    posts.stream()
                            .filter(p -> p.getId() == id)
                            .findFirst()
                            .ifPresentOrElse(
                                    p -> {
                                        p.addComment(comment);
                                        System.out.println("Comment added.");
                                    },
                                    () -> System.out.println("Post not found.")
                            );
                }
                case 0 -> {}
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }
}
