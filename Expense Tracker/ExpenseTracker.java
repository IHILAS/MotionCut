import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {

    static class Expense {
        private String name;
        private double amount;
        private String category;
        private String date;

        public Expense(String name, double amount, String category, String date) {
            this.name = name;
            this.amount = amount;
            this.category = category;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Expense [Name=" + name + ", Amount=" + amount + ", Category=" + category + ", Date=" + date + "]";
        }
    }

    private List<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String name, double amount, String category, String date) {
        Expense expense = new Expense(name, amount, category, date);
        expenses.add(expense);
    }

    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    public double getTotalExpenses() {
        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        return total;
    }

    public void removeExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense removed successfully.");
        } else {
            System.out.println("Invalid index. No expense removed.");
        }
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Remove Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter expense name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter expense date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();

                    expenseTracker.addExpense(name, amount, category, date);
                    System.out.println("Expense added successfully.");
                    break;

                case "2":
                    System.out.println("\nRecorded Expenses:");
                    expenseTracker.displayExpenses();
                    break;

                case "3":
                    double totalExpenses = expenseTracker.getTotalExpenses();
                    System.out.println("\nTotal Expenses: $" + totalExpenses);
                    break;

                case "4":
                    System.out.println("\nRecorded Expenses:");
                    expenseTracker.displayExpenses();
                    System.out.print("Enter the index of the expense to remove: ");
                    int index = scanner.nextInt() - 1; // Subtract 1 to match list index
                    scanner.nextLine(); // Consume newline
                    expenseTracker.removeExpense(index);
                    break;

                case "5":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!choice.equals("5"));

        scanner.close();
    }
}
