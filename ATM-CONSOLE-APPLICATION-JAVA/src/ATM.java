import Note.Notes;

import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
    private static ArrayList<Notes> cashInventory = new ArrayList<>(); // Arraylist for Notes
    private static double atmBalance; // Variable to manage atm balance
    private static ArrayList<Account> allAccount = new ArrayList<>();

    public static void start() throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);//Scanner object
        AdminAction adminAction = new AdminAction(); // Constructor for adminAction
        UserAction userAction = new UserAction(); // Constructor for userAction

        allAccount.add(new Admin("123", "123")); // Adding default admin

        while (true) { // Infinite loop
            System.out.println("Welcome to ATM System\n1. Admin Login\n2. User Login\n3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                Admin loginedAdmin =(Admin) AdminAction.adminLogin(allAccount, sc); //  Call and storing the return value of method adminLogin from AdminAction
                if (loginedAdmin != null) { // check if loginedAdmin is not equal to null
                    adminOptions(sc, adminAction,loginedAdmin);
                } else {
                    System.out.println("Invalid Admin ID or PIN.");
                }
            } else if (choice == 2) {
                User user=new User();
                User loginedUsers =(User) UserAction.userLogin(allAccount,user, sc); //  Call and storing the return value of method userLogin from UserAction
                if ( loginedUsers != null) { // check if loginedUser is not equal to null
                    userOptions(sc, userAction, loginedUsers);
                } else {
                    System.out.println("User Login Failed.");
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using the ATM.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private static void adminOptions(Scanner sc, AdminAction adminAction,Admin loginedAdmin) {  // Method to show Admin options
        while (true) {  // Infinite loop to keep showing Admin options until they exit
            System.out.println("Admin Actions:\n1. Add User\n2. Delete User\n3. View Users\n4. Add Money to ATM\n5. View Transactions\n6. ATM Balance\n7. View ATM Inventory \n8.Exit");
            int choice = sc.nextInt();  // Get Admin choice
            //Account account;
            if (choice == 1) {  // Add user
                adminAction.addUser(allAccount, sc);  // Call addUser method from AdminAction
            } else if (choice == 2) {  // Delete user
                adminAction.deleteUser(allAccount, sc);  // Call deleteUser method from AdminAction
            } else if (choice == 3) {  // View users
                adminAction.viewUsers(allAccount);  // Call viewUsers method from AdminAction
            } else if (choice == 4) {  // Add money to ATM
                adminAction.addMoneyToATM(cashInventory,loginedAdmin, sc);  // Call addMoneyToATM method from AdminAction
            } else if (choice == 5) {  // View transactions
                adminAction.viewTransaction(sc,allAccount);
            } else if (choice == 6) {  // View ATM balance
                atmBalance = AdminAction.calculateATMBalance(cashInventory);  // Calculate ATM balance
                System.out.println("Current ATM Balance: $" + atmBalance);  // Display ATM balance
            } else if (choice == 7) {
                adminAction.viewATMInventory(cashInventory); // Call viewATMInventory method from AdminAction
            } else if (choice == 8) {  // Exit Admin session
                System.out.println("Admin logged out");
                break;  // Break the loop and log out
            } else {  // Invalid choice
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void userOptions(Scanner sc, UserAction userAction,User logineduser ) throws CloneNotSupportedException {  // Method to show User options
        while (true) {  // Infinite loop to keep showing User options until they exit
            System.out.println("User Actions:\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. View Transactions\n5. Change pin\n6. Exit");
            int choice = sc.nextInt();  // Get User's choice

            if (choice == 1) {  // Withdraw money
                userAction.withdraw(logineduser, sc);
            } else if (choice == 2) {  // Deposit money
                userAction.deposit(logineduser, cashInventory, sc);  // Call deposit method from UserAction
            } else if (choice == 3) {  // Check balance
                System.out.println("Current Balance: $" + logineduser.getBalance());  // Display user's current balance
            } else if (choice == 4) {  // View transactions
                userAction.viewTransactions(logineduser);  // Call viewTransactions method from UserAction
            } else if (choice == 5) {  // Change pin
                userAction.changePin( logineduser, sc);  // Call changepin method from UserAction
            } else if (choice == 6) {  // Exit User session
                System.out.println("User logged out");
                break;  // Break the loop and log out
            } else {  // Invalid choice
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static ArrayList<Notes> getNotesArrayList() {
        return cashInventory;
    }
}
