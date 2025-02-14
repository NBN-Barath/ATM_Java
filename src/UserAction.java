import Note.Notes;
import Notes.Note100;
import Notes.Note200;
import Notes.Note2000;
import Notes.Note500;

import java.util.ArrayList;
import java.util.Scanner;

class UserAction implements CommonAction {

    public void changePin(Account account, Scanner sc) { // method to change pin
        System.out.println("Enter your User Pin:");
        String oldPin = sc.next(); // getting old user pin

        if (oldPin.equals((account.getPin()))) {// check the old pin is correct
            System.out.println("Enter your new User Pin:");
            String newUserPinCheckUp = sc.next(); // getting new user pin
            System.out.println("Re-Enter your new User Pin:");
            String newUserPinCheckUpReEnter = sc.next(); // check new user pin
            if (newUserPinCheckUp.equals(newUserPinCheckUpReEnter)){
                account.setPin(newUserPinCheckUp); // setting the new pin
                System.out.println("Your pin was changed successfully.");
            }else {
                System.out.println("Re-Entered user pin is wrong");
            }


        } else {
            System.out.println("Incorrect PIN.");
        }
    }

public void withdraw(User customer, Scanner sc) throws CloneNotSupportedException {
    System.out.print("Enter amount to withdraw: ");
    double amount = sc.nextDouble();  // Amount to withdraw
    double finalAmount = amount;
    ArrayList<String> note_Tr = new ArrayList<>();  // Transaction log for notes

    while (amount != 0) {
        boolean denominationFound = false;  // variable to check if withdrawal is possible
        for (Notes note : ATM.getNotesArrayList()) {  // Iterate directly on ATM inventory
            int noteValue = note.getNoteValue();
            int availableNotes = note.getNoteCount();
            int requiredNotes = (int) (amount / noteValue);

            if (requiredNotes > 0 && noteValue <= amount && availableNotes > 0) {
                int notesToWithdraw = Math.min(requiredNotes, availableNotes);  // Use the lesser of required and available

                // Show how the amount is changing after each withdrawal
                System.out.println("Withdrawing " + notesToWithdraw + " notes of " + noteValue);

                amount -= notesToWithdraw * noteValue;  // Deduct from the amount
                note.setNoteCount(availableNotes - notesToWithdraw);  // Update the note count in the ATM inventory
                note_Tr.add("You got " + notesToWithdraw + " notes of " + noteValue);
                denominationFound = true;
            }

            // If the withdrawal amount is fully covered it break
            if (amount == 0) {
                customer.addTransaction(new Transaction("withdraw", finalAmount, customer.getId()));
                customer.setBalance(customer.getBalance() - finalAmount);
                ATM.setAtmBalance(ATM.getAtmBalance() - finalAmount);
                break;
            }
        }

        // If no suitable denominations were found, stop the withdrawal
        if (!denominationFound || amount != 0) {
            System.out.println("Insufficient denominations or unable to withdraw the exact amount. Please try again with a different amount.");
            return;
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
            CommonAction.addToCashInventory(cashInventory, new Note2000(num2000)); // Adding num2000 in note2000
            CommonAction.addToCashInventory(cashInventory, new Note500(num500)); // Adding num500 in note500
            CommonAction.addToCashInventory(cashInventory, new Note200(num200)); // Adding num200 in note200
            CommonAction.addToCashInventory(cashInventory, new Note100(num100)); // Adding num100 in note100

            user.setBalance(user.getBalance() + amount); // Update user's balance

            // Adding transaction for the user
            Transaction transaction = new Transaction("Deposit", amount, user.getId());
            user.addTransaction(transaction);

            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit amount does not match the denomination counts.");
        }
    }
}
