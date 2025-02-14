import java.util.ArrayList;

public abstract class Account {
    protected String accountId; // Variable to store account id
    protected String pin; // Variable to store the account pin
    protected ArrayList<Transaction> transactions; // ArrayList to store the transaction of the account

    public Account(String accountId, String pin) { // Constructor to store accountId,pin and transaction
        this.accountId = accountId;
        this.pin = pin;
        this.transactions = new ArrayList<>();
    }

    // Abstract methods of getter and setter
    public abstract String getId();
    public abstract String getPin();
    public abstract void setPin(String pin);
    public abstract ArrayList<Transaction> getTransactions();
    public abstract void addTransaction(Transaction transaction);

}