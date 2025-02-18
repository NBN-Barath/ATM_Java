import Note.Notes;
import Notes.Note100;
import Notes.Note200;
import Notes.Note2000;
import Notes.Note500;

import java.util.ArrayList;
import java.util.Scanner;

class AdminAction implements AdminActionInterface{

    CommonAction commonAction = new CommonAction();
    @Override
    public void addUser(ArrayList<Account> allAccounts, Scanner sc) { // Method to add a user
        System.out.print("Enter new User ID: ");
        String userId = sc.next();
        for (Account acc : allAccounts) { // Iterates the user information from list
            if (acc.getId().equals(userId)) { // Check if User ID already exists
                System.out.println("User ID already exists. Try a different ID.");
                return;
            }
        }
        System.out.print("Enter new User PIN: ");
        String userPin = sc.next();
        // Add the new user to the account list
        User newUser = new User(userId, userPin); // Store the user details in User variable
        allAccounts.add(newUser); // adding the new user in allAccount
        System.out.println("User added successfully.");
    }

    @Override
    public void deleteUser(ArrayList<Account> accounts, Scanner sc) { // Method to delete a user
        System.out.print("Enter User ID to delete: ");
        String userId = sc.next();

        boolean userFound = false;
        for (Account account : accounts) { // Iterates the user information from list
            if (account.getId().equals(userId)) { // Check th given id is equal to given id
                accounts.remove(account); // Delete the user from the user list
                System.out.println("User " + userId + " deleted successfully.");
                userFound = true;
                break;
            }else {
                System.out.println("No user is found");
            }
        }
        if (!userFound) { // if user not found
            System.out.println("User with ID " + userId + " not found.");
        }
    }
    @Override
    public void viewUsers(ArrayList<Account> accounts) { // Method to view all user
        System.out.println("List of Users:");
        for (Account account : accounts) { // Iterates the user information from list
            if (account instanceof User) { // check if account is instance of user(here account is above declared in for loop)
                User user = (User) account; // Cast to User
                System.out.println("User ID: " + account.getId()+"\t\tBalance: $" + user.getBalance()+"\n"); // Print account details
            }
        }
    }

@Override
    public void addMoneyToATM(NotesList<Notes> cashInventory, Admin loginedAdmin, Scanner sc) { // Method to add money in atm
        System.out.println("Enter the amount of money to add to the ATM:");
        double total = sc.nextDouble();
        System.out.print("Enter number of 100 denomination notes: ");
        int num100 = sc.nextInt();
        System.out.print("Enter number of 200 denomination notes: ");
        int num200 = sc.nextInt();
        System.out.print("Enter number of 500 denomination notes: ");
        int num500 = sc.nextInt();
        System.out.print("Enter number of 2000 denomination notes: ");
        int num2000 = sc.nextInt();

        double totalAmount = (num100 * 100) + (num200 * 200) + (num500 * 500) + (num2000 * 2000);

        if(totalAmount == total){ // If to check the money you entered nd given is equal
            System.out.println("Total amount to be added to ATM: $" + totalAmount);

            commonAction.addToCashInventory(cashInventory, new Note2000(num2000)); // Adding num2000 in note2000
            commonAction.addToCashInventory(cashInventory, new Note500(num500)); // Adding num500 in note500
            commonAction.addToCashInventory(cashInventory, new Note200(num200)); // Adding num200 in note200
            commonAction.addToCashInventory(cashInventory, new Note100(num100)); // Adding num100 in note100

            loginedAdmin.addTransaction(new Transaction("Deposit", totalAmount,"Admin"));
            System.out.println("Money added successfully to ATM.");
        }
        else {
            System.out.println("Deposit amount does not match the denomination counts.");
        }

    }
@Override
    public double calculateATMBalance(NotesList<Notes> cashInventory) { // method to check ATM balance
        double totalBalance = 0;
        for (Notes note : cashInventory.getAllNoteList()) { // Iterates the notes from cashInventory
            totalBalance += note.getNoteCount() * note.getNoteValue();
        }
        return totalBalance;
    }@Override
    public void viewATMInventory(NotesList<Notes> cashInventory){ // method to view ATM Inventory
        for (Notes note : cashInventory.getAllNoteList()) { // Iterates the notes from cashInventory
            System.out.println(note.getNoteValue() + " : " + note.getNoteCount());
        }
    }
@Override
    public void viewTypeOfTransaction(Scanner sc,ArrayList<Account>accounts){ // Method to view transaction
        while (true){
            System.out.println("Enter your choice:\n1. View Atm Transactions\n2. View User Transactions\n3. View All Transactions\n4. Exit");
            int choice = sc.nextInt();
            if (choice == 1){
                viewAtmTransactions(accounts);
            } else if (choice == 2){
                viewUserTransaction(sc,accounts);
            } else if (choice ==3) {
                viewAllTransactions(accounts);
            } else if (choice == 4) {
                System.out.println("Exiting from view transaction....");
                return;
            } else {
                System.out.println("Enter a valid choice");
            }
        }

    }
    @Override
    public void viewAllTransactions(ArrayList<Account> allAccounts) { // Method to view all transaction
        System.out.println("All Transactions:");
        String typeOfUser ;
        for (Account account : allAccounts) { // Iterate through all accounts and display their transactions
            if(account instanceof Admin){ // check the type of user
                typeOfUser = "ATM";
            }
            else {
                typeOfUser = "User";
            }
            System.out.println("Transactions for " + typeOfUser + ": " + account.getId());
            commonAction.viewTransactions(account);
        }
    }

    @Override
    public void viewAtmTransactions(ArrayList<Account> allAccounts) { // Method to view all ATM transaction
        boolean foundAdmin = false;
        for (Account account : allAccounts) { // Iterate through all accounts and display their transactions
            if (account instanceof Admin) { // Find the Admin account and display its transactions
                System.out.println("Transactions for ATM:");
                commonAction.viewTransactions(account); // Calling view Transaction function
                foundAdmin = true;
                break;
            }
        }

        if (!foundAdmin) { // if admin transaction not found
            System.out.println("No ATM transactions found.");
        }
    }

    @Override
    public void viewUserTransaction(Scanner sc,ArrayList<Account> accounts) { // Method to view User transaction
        while (true) {
            System.out.println("Enter the choice \n 1. Specific user \n 2. All user \n 3.Exit");
            int choice = sc.nextInt();
            if (choice == 1){
                viewSpecificUserTransactions(sc,accounts);
            } else if (choice == 2) {
                viewAllUserTransaction(accounts);
            } else if (choice == 3) {
                System.out.println("Exiting from view user transaction...");
                return;
            }
            else {
                System.out.println("Enter a valid choice");
            }
        }
    }
    @Override
    public void viewAllUserTransaction(ArrayList<Account> allAccounts) { // Method to view all User transaction
        System.out.println("All User Transactions:");
        for (Account acc : allAccounts) { // Iterate through all accounts and display their transactions
            if (acc instanceof User) { // Find the Admin account and display its transactions
                System.out.println("Transactions for User: " + acc.getId());
                commonAction.viewTransactions(acc);// Display the Transaction of specific user
            }
        }
    }
@Override
    public void viewSpecificUserTransactions(Scanner sc, ArrayList<Account> accounts) { // Method to view specific User transaction
        System.out.println("Enter User ID to view transactions:");
        String userId = sc.next();
        for (Account account : accounts) { // Iterate through all accounts and display their transactions
            if (account.getId().equals(userId)) { // if user id id=s equal to entered id
                System.out.println("Transactions for User: " + userId);
                for (Transaction transaction : account.getTransactions()) { // Iterate through all accounts and display their transactions
                    System.out.println(transaction); // Print transaction
                }
                return;
            }
        }
        System.out.println("User not found!");
    }
}
