import java.util.ArrayList;

class User extends Account {
    private double balance; // Store user balance amount

    public User(String userId, String userPin) { // Constructor
        super(userId, userPin);
    }

    // Getters and Setters
    @Override
    public String getId() {
        return super.accountId;
    }

    @Override
    public String getPin() {
        return super.pin;
    }

    @Override
    public void setPin(String pin) {
        super.pin = pin;
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return super.transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        super.transactions.add(transaction);
    }

    public double getBalance() { // User balance getter
        return balance;
    }

    public void setBalance(double balance) { // User balance setter
        this.balance = balance;
    }
}
