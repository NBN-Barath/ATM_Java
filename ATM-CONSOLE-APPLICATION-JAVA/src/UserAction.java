import Note.Notes;
import Notes.Note100;
import Notes.Note200;
import Notes.Note2000;
import Notes.Note500;

import java.util.ArrayList;
import java.util.Scanner;

class UserAction {

    public static Account userLogin(ArrayList<Account> accounts, User user, Scanner sc) { // Method user login
        System.out.print("Enter User ID: ");
        String userId = sc.next();
        int incrementer = 0;

        for (Account account : accounts) { // Iterate through all accounts
            if (account instanceof User) { // Iterate all account in account list
                if (account.getId().equals(userId)) { // check account is instance of user
                    while (incrementer < 3) { // Allow up to 3 login attempts
                        System.out.print("Enter User PIN: ");
                        String userPin = sc.next();

                        if (account.getPin().equals(userPin)) { // Check admin pin is valid
                            System.out.println("User login successful.");
                            return account;// return user when login is successful
                        } else {
                            incrementer++; // add incrementer
                            int remainingAttempts = 3 - incrementer; // Decreasing remaining attempt
                            if (remainingAttempts == 0) { // Check the remaining attempt
                                System.out.println("User account locked due to too many failed attempts.");
                                return null;
                            } else {
                                System.out.println("Incorrect PIN. You have " + remainingAttempts + " attempts left.");
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Invalid User ID.");
        return null;
    }

    public void changePin(Account account, Scanner sc) { // method to change pin
        System.out.println("Enter your User Pin:");
        String oldPin = sc.next();

        if (oldPin.equals((account.getPin()))) {// check the old pin is correct
            System.out.println("Enter your new User Pin:");
            String newUserPin = sc.next();
            System.out.println("Re-Enter your new User Pin:");
            String newUserPinCheckUp = sc.next();

            account.setPin(newUserPin); // setting the new pin
            System.out.println("Your pin was changed successfully.");
        } else {
            System.out.println("Incorrect PIN.");
        }
    }

    public void withdraw(User customer, Scanner sc) throws CloneNotSupportedException {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();  // Amount to withdraw
        double finalAmount = amount;
        ArrayList<String> note_Tr = new ArrayList<>();  // Transaction log for notes
        ArrayList<Notes> Note_Dp = new ArrayList<>();   // Cloned list of notes

        // Clone the ATM notes to simulate withdrawal
        for (Notes note : ATM.getNotesArrayList()) {
            Note_Dp.add(note.clone());
        }

        while (amount != 0) {
            boolean denominationFound = false;  // variable to check denomination can be used
            for (Notes note : Note_Dp) {
                int noteValue = note.getNoteValue();// store the note value
                int availableNotes = note.getNoteCount();// store the note count
                int requiredNotes = (int) (amount / noteValue);// calculate the required note

                if (requiredNotes > 0 && noteValue <= amount && availableNotes > 0) {
                    int notesToWithdraw = Math.min(requiredNotes, availableNotes);  // Use the lesser of required and available
                    // Debugging: Show how the amount is changing after each withdrawal
                    System.out.println("Withdrawing " + notesToWithdraw + " notes of " + noteValue);
                    amount -= notesToWithdraw * noteValue;  // Deduct from the amount
                    note.setNoteCount(availableNotes - notesToWithdraw);  // Update the note count in the ATM
                    note_Tr.add("You got " + notesToWithdraw + " notes of " + noteValue);
                    denominationFound = true;  // Set the flag to true as we have withdrawn some notes
                }

                // If the withdrawal amount is reduced to 0, break out of the loop
                if (amount == 0) {
                    customer.addTransaction(new Transaction("withdraw",finalAmount, customer.getId()));
                    customer.setBalance(customer.getBalance() - finalAmount);
                    break;
                }
            }

            // If no denomination could fulfill the withdrawal, or the amount is still non-zero
            if (!denominationFound || amount != 0) {
                System.out.println("Insufficient denominations or unable to withdraw the exact amount. Please try again with a different amount.");
                return;  // Exit withdrawal if no denominations could satisfy the request
            }
        }
    }
    public void deposit(User user, ArrayList<Notes> cashInventory, Scanner sc) {
        System.out.print("Enter total amount to deposit: ");
        double amount = sc.nextDouble();

        System.out.print("Enter number of 100 denomination notes: ");
        int num100 = sc.nextInt();
        System.out.print("Enter number of 200 denomination notes: ");
        int num200 = sc.nextInt();
        System.out.print("Enter number of 500 denomination notes: ");
        int num500 = sc.nextInt();
        System.out.print("Enter number of 2000 denomination notes: ");
        int num2000 = sc.nextInt();


        double totalAmount = (num100 * 100) + (num200 * 200) + (num500 * 500) + (num2000 * 2000);

        if (amount == totalAmount) {
            addToCashInventory(cashInventory, new Note2000(num2000)); // Adding num2000 in note2000
            addToCashInventory(cashInventory, new Note500(num500)); // Adding num500 in note500
            addToCashInventory(cashInventory, new Note200(num200)); // Adding num200 in note200
            addToCashInventory(cashInventory, new Note100(num100)); // Adding num100 in note100

            user.setBalance(user.getBalance() + amount); // Update user's balance

            // Adding transaction for the user
            Transaction transaction = new Transaction("Deposit", amount, user.getId());
            user.addTransaction(transaction);

            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit amount does not match the denomination counts.");
        }
    }


    private void addToCashInventory(ArrayList<Notes> cashInventory, Notes newNote) { // method to add money to inventory
        boolean found = false;

        for (Notes note : cashInventory) { // Iterates the notes from cashInventory
            if (note.getNoteValue() == newNote.getNoteValue()) { // check the get note value to new note value
                note.setNoteCount(note.getNoteCount() + newNote.getNoteCount()); // set the old not value + new note vale
                found = true;
                break;
            }
        }
        if (!found) { // if not found
            cashInventory.add(newNote); // add new note
        }
    }

    public void viewTransactions(Account account) {
        if (account.getTransactions().isEmpty()) { // Check if the transaction is empty or not
            System.out.println("No transactions available for this account.");
        } else {
            System.out.println("User Transactions:");
            for (Transaction transaction : account.getTransactions()) { // Iterate transaction of account
                System.out.println(transaction);
            }
        }
    }
}
