import Note.Notes;

import java.util.ArrayList;
public class ATM {
    private static NotesList<Notes> cashInventory = new NotesList<>(); // Arraylist for Notes
    private static double atmBalance; // Variable to manage atm balance
    private static ArrayList<Account> allAccount = new ArrayList<>();

    public static ArrayList<Account> getAllAccount() {
        return allAccount;
    }

    public static NotesList<Notes> getCashInventory() {
        return cashInventory;
    }


    public static NotesList<Notes> getNotesArrayList() {
        return cashInventory;
    }

    public static double getAtmBalance() {
        return atmBalance;
    }

    public static void setAtmBalance(double atmBalance) {
        ATM.atmBalance = atmBalance;
    }
}
