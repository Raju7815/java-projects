import java.util.ArrayList;
import java.util.Scanner;

public class PersonalExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Expense expense = new Expense(date, category, description, amount);
        expenses.add(expense);
        System.out.println("Expense added successfully.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to show.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    private static void deleteExpense(Scanner scanner) {
        System.out.print("Enter the index of the expense to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense deleted successfully.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }
}
class Expense {
    private String date;
    private String category;
    private String description;
    private double amount;

    public Expense(String date, String category, String description, double amount) {
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
