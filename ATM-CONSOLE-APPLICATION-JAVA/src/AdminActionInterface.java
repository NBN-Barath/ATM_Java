import Note.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public interface AdminActionInterface {
     // all method declaration
     void addUser(ArrayList<Account> allAccounts, Scanner sc) ;
     void deleteUser(ArrayList<Account> accounts, Scanner sc) ;
     void viewUsers(ArrayList<Account> accounts) ;
     void addMoneyToATM(NotesList<Notes> cashInventory, Admin loginedAdmin, Scanner sc) ;
     double calculateATMBalance(NotesList<Notes> cashInventory);
     void viewATMInventory(NotesList<Notes> cashInventory);
     void viewTypeOfTransaction(Scanner sc,ArrayList<Account>accounts);
     void viewAllTransactions(ArrayList<Account> allAccounts);
     void viewAtmTransactions(ArrayList<Account> allAccounts);
     void viewUserTransaction(Scanner sc,ArrayList<Account> accounts);
     void viewAllUserTransaction(ArrayList<Account> allAccounts);
     void viewSpecificUserTransactions(Scanner sc, ArrayList<Account> accounts);
    }
