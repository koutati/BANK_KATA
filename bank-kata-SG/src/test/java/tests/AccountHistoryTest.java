package tests;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Test;
import org.mockito.InOrder;

import bank.Account;
import bank.Screen;
import bank.ConsoleHistoryPrinter;
import bank.TransactionsHistory;
import bank.HistoryLineFormatter;
import bank.SystemDate;

public class AccountHistoryTest {

    @Test
    public void bankingTest() {

        Screen screen = mock(Screen.class);
        SystemDate systemDate = mock(SystemDate.class);
        when(systemDate.now()).thenReturn(new Date()).thenReturn(new Date())
                .thenReturn(new Date());

        Account account = new Account(new ConsoleHistoryPrinter(screen,
                new HistoryLineFormatter()), new TransactionsHistory(systemDate));

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);
        InOrder inOrder = inOrder(screen);

        account.showHistory();

        inOrder.verify(screen).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(screen).printLine("09/11/2022 | 500.00 | 1400.00");
        inOrder.verify(screen).printLine("09/11/2022 | -100.00 | 900.00");
        inOrder.verify(screen).printLine("09/11/2022 | 1000.00 | 1000.00");
    }
}
