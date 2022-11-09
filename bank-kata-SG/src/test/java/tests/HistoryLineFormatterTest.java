package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.junit.Test;

import bank.HistoryLine;
import bank.HistoryLineFormatter;
import bank.Transaction;

public class HistoryLineFormatterTest {

    @Test
    public void showTransactionOnScreen() {
        final Date A_DATE = new Date();
        final HistoryLineFormatter historyLineFormatter = new HistoryLineFormatter();

        assertThat(
                historyLineFormatter.format(new HistoryLine(new Transaction(500, A_DATE), 1500)),
                is("09/11/2022 | 500.00 | 1500.00"));
    }

}
