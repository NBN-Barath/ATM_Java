import java.util.Scanner;

public interface ATM_ActionInterface {
     // all method declaration
     void start() throws CloneNotSupportedException;
     void userOptions(Scanner sc, UserAction userAction, User logineduser ) throws CloneNotSupportedException;
     void adminOptions(Scanner sc, AdminAction adminAction,Admin loginedAdmin);

}
