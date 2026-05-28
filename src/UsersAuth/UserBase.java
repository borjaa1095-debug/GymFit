package UsersAuth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public abstract class UserBase {

    private String username;

    private String password;

    public UserBase(String username, String password) {
        this.username = username;

        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(String filePathUsers, String filePathTrainers) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Login as (user/trainer): ");
        String type = sc.nextLine().toLowerCase();

        while (!type.equals("user") && !type.equals("trainer")) {
            System.out.println("Invalid option. Type 'user' or 'trainer'");
            type = sc.nextLine().toLowerCase();
        }

        String targetFile = type.equals("user") ? filePathUsers : filePathTrainers;

        System.out.print("Enter username: ");
        String inputUser = sc.nextLine();

        System.out.print("Enter password: ");
        String inputPass = sc.nextLine();

        String result = "none";

        try (BufferedReader br = new BufferedReader(new FileReader(targetFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts.length == 2) {
                    boolean userMatch = inputUser.equals(parts[0]);
                    boolean passMatch = inputPass.equals(parts[1]);

                    if (userMatch && passMatch) {
                        result = type;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }


        return result;
    }



    public boolean register(String filePathUsers, String filePathTrainers) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What do you want to register? (user/trainer)");
        String type = sc.nextLine().toLowerCase();

        while (!type.equals("user") && !type.equals("trainer")) {
            System.out.println("Invalid option. Type 'user' or 'trainer'");
            type = sc.nextLine().toLowerCase();
        }

        System.out.print("New username: ");
        String newUser = sc.nextLine();

        System.out.print("New password: ");
        String newPass = sc.nextLine();

        boolean exists = false;

        // Select the correct file depending on the type
        String targetFile = type.equals("user") ? filePathUsers : filePathTrainers;

        // 1. Check if the user already exists in the correct file
        try (BufferedReader br = new BufferedReader(new FileReader(targetFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts.length == 2) {
                    String fileUser = parts[0];

                    if (newUser.equals(fileUser)) {
                        exists = true;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        if (exists) {
            System.out.println("User already exists. Registration cancelled.");
            return false;
        }

        // 2. Register the new user in the correct file
        try (FileWriter fw = new FileWriter(targetFile, true)) {
            fw.write(newUser + ":" + newPass + "\n");
            System.out.println("User successfully registered in " + targetFile);
            return true;

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

}
