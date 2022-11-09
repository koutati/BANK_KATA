package bank;

import java.util.ArrayList;
import java.util.List;

public class TransactionsHistory implements Transactions {

    public static final int INITIAL_BALANCE = 0;
    private final List<Transaction> transactions;
    private final SystemDate systemDate;

    public TransactionsHistory(final SystemDate systemDate) {
        transactions = new ArrayList<Transaction>();
        this.systemDate = systemDate;
    }

    @Override
    public void save(final int amount) {
        transactions.add(new Transaction(amount, systemDate.now()));
    }

    @Override
    public Boolean contains(final Transaction transaction) {
        return transactions.contains(transaction);
    }

    @Override
    public History generateHistory() {
        List<HistoryLine> historyLines = getHistoryLinesInTransactionsOrder();

       return History.create(historyLines);
    }

    private List<HistoryLine> getHistoryLinesInTransactionsOrder() {
        List<HistoryLine> historyLines = new ArrayList<>();
        int balance = INITIAL_BALANCE;
        for (final Transaction transaction : transactions) {
            balance += transaction.amount();
            historyLines.add(new HistoryLine(transaction, balance));
        }
        return historyLines;
    }
}
