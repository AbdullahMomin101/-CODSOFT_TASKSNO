import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double startingBalance) {
        balance = startingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposite(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposite : ₹%.2f%n", amount);
        } else System.out.println("Enter a amount greater than zero");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a amount greater than zero");
        } else if (amount > balance) {
            System.out.println("Insuffient balance");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: ₹%.2f%n", amount);
        }
    }
}


public class AtmInterface {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);
        int choice;


        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposite");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("choose an option");
            while (!scanner.hasNextInt()) {
                System.out.print("Enter a number form 1 - 4");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: ₹%.2f%n", account.getBalance());
                    break;
                case 2:
                    System.out.print("Amount to deposite: ₹");
                    if (scanner.hasNextDouble()) {
                        account.deposite((scanner.nextDouble()));
                    } else {
                        System.out.println("Please Enter a valid amount");
                        scanner.next();
                    }
                    break;
                case 3:
                    System.out.println("Amount to withdraw: ₹");
                    if (scanner.hasNextDouble()) {
                        account.withdraw(scanner.nextDouble());
                    } else {
                        System.out.println("Please Enter a valid Amount");
                        scanner.next();
                    }
                    break;
                case 4:
                    System.out.println("Thanks for using the ATM");
                    break;
                default:
                    System.out.println("Choose an option between 1 - 4");
            }
        } while (choice != 4);
        scanner.close();
    }
}
