package SessionPayment;

import java.time.LocalDate;

public class Payment {

    private int paymentId;
    private String username;
    private double amount;
    private String method;
    private String date;
    private boolean paid;

    public Payment(int paymentId, String username, double amount, String method) {
        this.paymentId = paymentId;
        this.username = username;
        this.amount = amount;
        this.method = method;
        this.date = LocalDate.now().toString();
        this.paid = false;
    }

    public int getPaymentId() { return paymentId; }
    public String getUsername() { return username; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getDate() { return date; }
    public boolean isPaid() { return paid; }
    public void setMethod(String method) { this.method = method; }

    public void setAmount(double amount) {
        if (amount < 0) {
            System.out.println("El importe no puede ser negativo.");
        } else {
            this.amount = amount;
        }
    }

    public boolean processPayment() {
        boolean result = false;
        if (paid) {
            System.out.println("Este pago ya fue procesado.");
        } else if (amount <= 0) {
            System.out.println("Importe inválido. No se puede procesar el pago.");
        } else {
            paid = true;
            System.out.println("Pago procesado correctamente:");
            displayPaymentInfo();
            result = true;
        }
        return result;
    }

    public void displayPaymentInfo() {
        System.out.println("=== Pago ID: " + paymentId + " ===");
        System.out.println("Usuario: " + username);
        System.out.println("Importe: " + amount + "€");
        System.out.println("Método: " + method);
        System.out.println("Fecha: " + date);
        System.out.println("Estado: " + (paid ? "PAGADO" : "PENDIENTE"));
    }
}