package tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import bank.Account;
import bank.HistoryPrinter;
import bank.Transactions;

public class AccountTest {
    HistoryPrinter historyPrinter;
    private Transactions transactions;
    private Account account;

    @Before
    public void setUp() {
        historyPrinter = mock(HistoryPrinter.class);
        transactions = mock(Transactions.class);
        account = new Account(historyPrinter, transactions);
    }

    @Test
    public void deposit() {
        account.deposit(100);

        verify(transactions).save(100);
    }

    @Test
    public void withdraw() {
        account.withdraw(100);

        verify(transactions).save(-100);
    }
}
