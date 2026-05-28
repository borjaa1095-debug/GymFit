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
            System.out.println("The import can't be negative.");
        } else {
            this.amount = amount;
        }
    }

    public boolean processPayment() {
        boolean result = false;
        if (paid) {
            System.out.println("This payment has been already processed.");
        } else if (amount <= 0) {
            System.out.println("Invalid import. The payment can't be processed.");
        } else {
            paid = true;
            System.out.println("Payment processed correctly:");
            displayPaymentInfo();
            result = true;
        }
        return result;
    }

    public void displayPaymentInfo() {
        System.out.println("=== Payment ID: " + paymentId + " ===");
        System.out.println("User: " + username);
        System.out.println("Import: " + amount + "€");
        System.out.println("Method: " + method);
        System.out.println("Date: " + date);
        System.out.println("Status: " + (paid ? "PAGADO" : "PENDIENTE"));
    }
}