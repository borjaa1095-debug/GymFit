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
            System.out.println("1. Crear nueva sesión");
            System.out.println("2. Ver todas las sesiones");
            System.out.println("3. Registrar participante en sesión");
            System.out.println("4. Eliminar participante de sesión");
            System.out.println("5. Procesar pago");
            System.out.println("6. Ver pagos");
            System.out.println("0. Volver");
            System.out.print("Elige opción: ");
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
                System.out.println("Volviendo al menú principal...");
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void crearSesion() {
        System.out.print("Nombre de la clase: ");
        String nombre = sc.nextLine();
        System.out.print("Trainer: ");
        String trainer = sc.nextLine();
        System.out.print("Fecha (dd/mm/yyyy): ");
        String fecha = sc.nextLine();
        System.out.print("Capacidad máxima: ");
        int capacidad = leerInt();

        ClassSession session = new ClassSession(nextSessionId, nombre, trainer, fecha, capacidad);
        nextSessionId++;
        sessions.add(session);
        System.out.println("Sesión creada con ID " + session.getSessionId());
    }

    private void verSesiones() {
        if (sessions.isEmpty()) {
            System.out.println("No hay sesiones registradas.");
        } else {
            for (ClassSession s : sessions) {
                s.displaySessionInfo();
                System.out.println();
            }
        }
    }

    private void registrarParticipante() {
        if (sessions.isEmpty()) {
            System.out.println("No hay sesiones disponibles.");
        } else {
            System.out.print("ID de la sesión: ");
            int id = leerInt();
            ClassSession session = buscarSesion(id);
            if (session == null) {
                System.out.println("Sesión no encontrada.");
            } else {
                System.out.print("Nombre del participante: ");
                String nombre = sc.nextLine();
                session.addParticipant(nombre);
            }
        }
    }

    private void eliminarParticipante() {
        if (sessions.isEmpty()) {
            System.out.println("No hay sesiones disponibles.");
        } else {
            System.out.print("ID de la sesión: ");
            int id = leerInt();
            ClassSession session = buscarSesion(id);
            if (session == null) {
                System.out.println("Sesión no encontrada.");
            } else {
                System.out.print("Nombre del participante a eliminar: ");
                String nombre = sc.nextLine();
                session.removeParticipant(nombre);
            }
        }
    }

    private void procesarPago() {
        System.out.print("Nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Importe (€): ");
        double importe = leerDouble();

        System.out.println("Método de pago:");
        System.out.println("1. Tarjeta  2. Efectivo  3. Transferencia");
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
            System.out.println("Importe inválido.");
        } else {
            Payment pago = new Payment(nextPaymentId, usuario, importe, metodo);
            nextPaymentId++;
            pago.processPayment();
            payments.add(pago);
        }
    }

    private void verPagos() {
        if (payments.isEmpty()) {
            System.out.println("No hay pagos registrados.");
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
            System.out.println("Entrada inválida, usando 0.");
        }
        return result;
    }

    private double leerDouble() {
        double result = 0;
        try {
            result = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida, usando 0.");
        }
        return result;
    }
}