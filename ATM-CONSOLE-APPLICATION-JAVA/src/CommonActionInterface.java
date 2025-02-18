import java.util.ArrayList;
import java.util.Scanner;
import Note.Notes;

public interface CommonActionInterface {
     // all method declaration
      void viewTransactions(Account account);
      void addToCashInventory(NotesList<Notes> cashInventory, Notes newNote);
      Account userLogin(ArrayList<Account> accounts, Scanner sc);
}
