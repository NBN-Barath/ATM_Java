import Note.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM_Action implements ATM_ActionInterface{
    private static NotesList<Notes> cashInventory = ATM.getCashInventory(); // Arraylist for Notes
    private static ArrayList<Account> allAccount = ATM.getAllAccount(); // Arraylist for Account
    static CommonAction commonAction = new CommonAction();
    @Override
    public  void start() throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);//Scanner object
        AdminAction adminAction = new AdminAction(); // Constructor for adminAction
        UserAction userAction = new UserAction(); // Constructor for userAction
        allAccount.add(new Admin("123", "123")); // Adding default admin

        while (true) {
            Account loginedAccount = commonAction.userLogin(allAccount, sc);// Call user login

            // Check type of user
            if(loginedAccount != null){
                if (loginedAccount instanceof Admin) {
                    adminOptions(sc,adminAction,(Admin) loginedAccount);
                }else if(loginedAccount instanceof User){
                    userOptions(sc,userAction,(User) loginedAccount);
                }
            }
        }
    }

    @Override
     public void adminOptions(Scanner sc, AdminAction adminAction, Admin loginedAdmin) {  // Method to show Admin options
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
                adminAction.viewTypeOfTransaction(sc,allAccount);
            } else if (choice == 6) {  // View ATM balance
                double ATMBalance = adminAction.calculateATMBalance(cashInventory);  // Calculate ATM balance
                System.out.println("Current ATM Balance: $" + ATMBalance);  // Display ATM balance
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
    @Override
     public void userOptions(Scanner sc, UserAction userAction,User logineduser ) throws CloneNotSupportedException {  // Method to show User options
        while (true) {  // Infinite loop to keep showing User options until they exit
            System.out.println("User Actions:\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. View Transactions\n5. Change pin\n6. Exit");
            int choice = sc.nextInt();  // Get User's choice

            if (choice == 1) {  // Withdraw money
                userAction.withdraw(logineduser, sc);
            } else if (choice == 2) {  // Deposit money
                userAction.deposit(logineduser, cashInventory,commonAction, sc);  // Call deposit method from UserAction
            } else if (choice == 3) {  // Check balance
                System.out.println("Current Balance: $" + logineduser.getBalance());  // Display user's current balance
            } else if (choice == 4) {  // View transactions
                commonAction.viewTransactions(logineduser);  // Call viewTransactions method from UserAction
            } else if (choice == 5) {  // Change pin
                userAction.changePin( logineduser, sc);  // Call changing pin method from UserAction
            } else if (choice == 6) {  // Exit User session
                System.out.println("User logged out");
                break;  // Break the loop and log out
            } else {  // Invalid choice
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
