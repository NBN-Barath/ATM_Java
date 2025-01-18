import java.util.ArrayList;

public class Account {
    private String accountId;
    private String pin;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String accountId, String pin) { // Constructor to store accountId and pin
        this.accountId = accountId;
        this.pin = pin;
        this.transactions = new ArrayList<>();
    }

    public Account() {}

    // Getters and Setters
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
