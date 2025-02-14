import Note.Notes;

import java.util.ArrayList;
public class ATM {
    private static ArrayList<Notes> cashInventory = new ArrayList<>(); // Arraylist for Notes
    private static double atmBalance; // Variable to manage atm balance
    private static ArrayList<Account> allAccount = new ArrayList<>();

    public static ArrayList<Account> getAllAccount() {
        return allAccount;
    }

    public static ArrayList<Notes> getCashInventory() {
        return cashInventory;
    }


    public static ArrayList<Notes> getNotesArrayList() {
        return cashInventory;
    }

    public static double getAtmBalance() {
        return atmBalance;
    }

    public static void setAtmBalance(double atmBalance) {
        ATM.atmBalance = atmBalance;
    }
}
