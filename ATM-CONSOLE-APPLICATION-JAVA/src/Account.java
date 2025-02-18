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


    public String getId() {
        return accountId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}