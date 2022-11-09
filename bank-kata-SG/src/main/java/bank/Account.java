package bank;

//author :kaoutar
public class Account {

    private final Transactions transactions;
    private final HistoryPrinter historyPrinter;

    public Account(final HistoryPrinter historyPrinter, final Transactions transactions) {
        this.transactions = transactions;
        this.historyPrinter = historyPrinter;
    }

    public void deposit(final int amount) {
        transactions.save(amount);
    }

    public void withdraw(final int amount) {
        transactions.save(-amount);
    }

    public void showHistory() {
        historyPrinter.print(transactions.generateHistory());
    }

}
