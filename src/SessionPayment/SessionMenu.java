package SessionPayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SessionMenu {

    private List<ClassSession> sessions = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private int nextSessionId = 1;
    private int nextPaymentId = 1;
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== MENU SESIONES Y PAGOS =====");
            System.out.println("1. Create new session");
            System.out.println("2. See all sesiones");
            System.out.println("3. Register participant on the session");
            System.out.println("4. Delete participant from the session");
            System.out.println("5. Process payment");
            System.out.println("6. See all payments");
            System.out.println("0. Go back");
            System.out.print("Choose: ");
            opcion = leerInt();

            if (opcion == 1) {
                crearSesion();
            } else if (opcion == 2) {
                verSesiones();
            } else if (opcion == 3) {
                registrarParticipante();
            } else if (opcion == 4) {
                eliminarParticipante();
            } else if (opcion == 5) {
                procesarPago();
            } else if (opcion == 6) {
                verPagos();
            } else if (opcion == 0) {
                System.out.println("Going back to the menu...");
            } else {
                System.out.println("Error");
            }
        }
    }

    private void crearSesion() {
        System.out.print("Name of the class: ");
        String nombre = sc.nextLine();
        System.out.print("Trainer: ");
        String trainer = sc.nextLine();
        System.out.print("Date (dd/mm/yyyy): ");
        String fecha = sc.nextLine();
        System.out.print("Maximum capacity: ");
        int capacidad = leerInt();

        ClassSession session = new ClassSession(nextSessionId, nombre, trainer, fecha, capacidad);
        nextSessionId++;
        sessions.add(session);
        System.out.println("Session created with ID " + session.getSessionId());
    }

    private void verSesiones() {
        if (sessions.isEmpty()) {
            System.out.println("There is no session registered.");
        } else {
            for (ClassSession s : sessions) {
                s.displaySessionInfo();
                System.out.println();
            }
        }
    }

    private void registrarParticipante() {
        if (sessions.isEmpty()) {
            System.out.println("There is no session right now.");
        } else {
            System.out.print("ID session: ");
            int id = leerInt();
            ClassSession session = buscarSesion(id);
            if (session == null) {
                System.out.println("Sesión not found.");
            } else {
                System.out.print("Participant name: ");
                String nombre = sc.nextLine();
                session.addParticipant(nombre);
            }
        }
    }

    private void eliminarParticipante() {
        if (sessions.isEmpty()) {
            System.out.println("There is no session available.");
        } else {
            System.out.print("ID session: ");
            int id = leerInt();
            ClassSession session = buscarSesion(id);
            if (session == null) {
                System.out.println("Sesión not found.");
            } else {
                System.out.print("Participant name to delete: ");
                String nombre = sc.nextLine();
                session.removeParticipant(nombre);
            }
        }
    }

    private void procesarPago() {
        System.out.print("Username: ");
        String usuario = sc.nextLine();
        System.out.print("Import (€): ");
        double importe = leerDouble();

        System.out.println("Payment method:");
        System.out.println("1. Credit card  2. Cash  3. Transfer");
        int metodoOpcion = leerInt();
        String metodo;
        if (metodoOpcion == 1) {
            metodo = "TARJETA";
        } else if (metodoOpcion == 2) {
            metodo = "EFECTIVO";
        } else if (metodoOpcion == 3) {
            metodo = "TRANSFERENCIA";
        } else {
            metodo = "DESCONOCIDO";
        }

        if (importe <= 0) {
            System.out.println("Invalid import.");
        } else {
            Payment pago = new Payment(nextPaymentId, usuario, importe, metodo);
            nextPaymentId++;
            pago.processPayment();
            payments.add(pago);
        }
    }

    private void verPagos() {
        if (payments.isEmpty()) {
            System.out.println("There is no payments registered.");
        } else {
            for (Payment p : payments) {
                p.displayPaymentInfo();
                System.out.println();
            }
        }
    }

    private ClassSession buscarSesion(int id) {
        ClassSession resultado = null;
        int i = 0;
        while (i < sessions.size() && resultado == null) {
            if (sessions.get(i).getSessionId() == id) {
                resultado = sessions.get(i);
            }
            i++;
        }
        return resultado;
    }

    private int leerInt() {
        int result = 0;
        try {
            result = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input or using 0.");
        }
        return result;
    }

    private double leerDouble() {
        double result = 0;
        try {
            result = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input or using 0.");
        }
        return result;
    }
}