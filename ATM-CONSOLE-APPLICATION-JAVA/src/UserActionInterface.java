import Note.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public interface UserActionInterface {
    // all method declaration
     void deposit(User user, NotesList<Notes> cashInventory,CommonAction commonAction, Scanner sc);
     void withdraw(User customer, Scanner sc) throws CloneNotSupportedException;
     void changePin(Account account, Scanner sc);
}
