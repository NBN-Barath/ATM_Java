import java.util.ArrayList;

class User extends Account {
    private double balance; // Store user balance amount

    public User(String userId, String userPin) { // Constructor
        super(userId, userPin);
    }

    public double getBalance() { // User balance getter
        return balance;
    }

    public void setBalance(double balance) { // User balance setter
        this.balance = balance;
    }
}
