import Note.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public interface CommonAction {
    static Account userLogin(ArrayList<Account> accounts, Scanner sc) { // Method user login
        System.out.print("Enter User ID: ");
        String userId = sc.next();
        int incrementer = 0;
        for (Account account : accounts) { // Iterate through all accounts
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

        System.out.println("Invalid User ID.");
        return null;
    }

    static void addToCashInventory(ArrayList<Notes> cashInventory, Notes newNote) { // method to add money to inventory

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

    static void viewTransactions(Account account) { // Method to view transaction
        if (account.getTransactions().isEmpty()) { // Check if the transaction is empty or not
            System.out.println("No transactions available for this account.");
        } else {
            for (Transaction transaction : account.getTransactions()) { // Iterate through all transaction and display their transactions
                System.out.println(transaction); // Print transaction
            }
        }
    }

}
