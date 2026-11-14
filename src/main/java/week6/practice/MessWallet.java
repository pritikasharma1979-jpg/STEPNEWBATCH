
package week6.practice;

public class MessWallet {

    // Private variable
    private double balance;

    // Constructor
    public MessWallet(double openingBalance) {

        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance. Starting with 0.");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    // Add money
    public void topUp(double amount) {

        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be positive");
        } else {
            balance = balance + amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    // Deduct money
    public void deduct(double amount) {

        if (amount <= 0) {
            System.out.println("Deduction rejected: Amount must be positive");
        } else if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println("Balance after deduction: " + balance);
        }
    }

    // Read-only access
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        // Create wallet with opening balance
        MessWallet wallet = new MessWallet(500);

        // Add money
        wallet.topUp(200);

        // Attempt to deduct money
        wallet.deduct(1000);

        // Display final balance
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
