package UsersAuth;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public abstract class UserBase {

    private String username;
    private String email;
    private int id;
    private String password;

    public UserBase(String username, String email, int id, String password) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean login(String filePath) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce usuario: ");
        String inputUser = sc.nextLine();

        System.out.print("Introduce contraseña: ");
        String inputPass = sc.nextLine();

        boolean result = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts.length == 2) {
                    String fileUser = parts[0];
                    String filePass = parts[1];

                    if (inputUser.equals(fileUser) && inputPass.equals(filePass)) {
                        result = true;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
        }

        System.out.println("Intento de login para usuario: " + inputUser + " - " + (result ? "Éxito" : "Fallo"));
        return result;
    }

    public boolean register(String filePath){
        boolean result = false;
    return result;
    }

}
