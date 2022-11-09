package tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bank.TransactionsHistory;
import bank.History;
import bank.HistoryLine;
import bank.SystemDate;
import bank.Transaction;
import bank.Transactions;

public class TransactionsHistoryTest {

    private static final Date A_DATE = new Date();
    private int amount;
    private SystemDate systemDate;
    private Transactions transactions;

    @Before
    public void setUp() {
        amount = 1;
        systemDate = mock(SystemDate.class);
        when(systemDate.now()).thenReturn(A_DATE);
        transactions = new TransactionsHistory(systemDate);
    }

    @Test
    public void storeTransaction() {
        transactions.save(amount);
        assertThat(transactions.contains(new Transaction(amount, A_DATE)), is(true));
    }

    @Test
    public void unknownTransaction() {
        transactions.save(amount);

        assertThat(transactions.contains(new Transaction(-amount, A_DATE)), is(false));
    }

    @Test
    public void showHistory() {
        systemDate = mock(SystemDate.class);
        when(systemDate.now()).thenReturn(new Date()).thenReturn(new Date());
        transactions = new TransactionsHistory(systemDate);
        transactions.save(100);
        transactions.save(-50);
        List<HistoryLine> historyLines = new ArrayList<HistoryLine>();
        historyLines.add(new HistoryLine(new Transaction(-50, new Date()), 50));
        historyLines.add(new HistoryLine(new Transaction(100, new Date()), 100));
        History expectedHistory = new History(historyLines);

        History history = transactions.generateHistory();

        assertThat(history, equalTo(expectedHistory));
    }
}
