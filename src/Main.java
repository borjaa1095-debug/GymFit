import UsersAuth.User;

public static void main(String[] args) {
    String filePath = "Users.txt";
    User u = new User("x", "x", 0, "x") {};

    boolean acceso = u.login(filePath);

    if (acceso) {
        System.out.println("Acceso concedido. Bienvenido!");
    } else {
        System.out.println("Acceso denegado.");
    }
}
