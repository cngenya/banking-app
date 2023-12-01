import java.util.Scanner;

class BankAccount {

    private String accountNumber;
    private String customerName;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, String customerName, double balance)
 
{
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    // Method to welcome the customer
    public void welcomeCustomer() {
        System.out.println("Welcome " + customerName + " to your bank account!");
    }

    // Method to show the current balance
    public void showBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    // Method to deposit money
    public void depositMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance += amount;
            System.out.println("You have successfully deposited " + amount + ".");
            System.out.printf("Your new balance is: %.2f\n", balance);
        }
    }

    // Method to withdraw money
    public void withdrawMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("You have successfully withdrawn " + amount + ".");
            System.out.printf("Your new balance is: %.2f\n", balance);
        }
    }

    // Method to generate a bank statement
    public void generateStatement() {
        System.out.println("Account Statement for " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: %.2f\n", balance);
    }
}

public
 
class
 
BankingApplication
 
{

    public
 
static
 
void
 
main(String[] args)
 
{
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter your initial deposit: ");
        double initialDeposit = scanner.nextDouble();

        BankAccount customerAccount = new BankAccount(accountNumber, customerName, initialDeposit);

        int choice;
        do {
            System.out.println("\nBanking Menu");
            System.out.println("1. Welcome Customer");
            System.out.println("2. Show Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Generate Statement");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customerAccount.welcomeCustomer();
                    break;
                case 2:
                    customerAccount.showBalance();
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    customerAccount.depositMoney(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    customerAccount.withdrawMoney(withdrawAmount);
                    break;
                case 5:
                    customerAccount.generateStatement();
                    break;
                case 6:
                    System.out.println("Thank you for using our banking application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}









