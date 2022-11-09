package tests;

import bank.*;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ConsoleHistoryPrinterTest {



    @Test
    public void showHostoryLineOnScreen() {
        final String header = "DATE | AMOUNT | BALANCE";
        final String formattedHistoryLine = "whatever";
        Screen screen = mock(Screen.class);
        final HistoryLineFormatter historyLineFormatter = mock(HistoryLineFormatter.class);
        when(historyLineFormatter.format(any(HistoryLine.class))).thenReturn(
                formattedHistoryLine);
        final HistoryPrinter historyPrinter = new ConsoleHistoryPrinter(screen,
                historyLineFormatter);
        HistoryLine historyLine = null;

        historyPrinter.print(new History(Arrays.asList(historyLine)));

        verify(screen).printLine(header);
        verify(screen).printLine(formattedHistoryLine);
    }
    
    
    
    @Test
    public void formatHistoryLine() {

        Screen screen = mock(Screen.class);
        final HistoryLineFormatter historyLineFormatter = mock(HistoryLineFormatter.class);
        final HistoryPrinter historyPrinter = new ConsoleHistoryPrinter(screen,
                historyLineFormatter);
        HistoryLine historyLine = new HistoryLine(
                new Transaction(100, new SystemDate().now()), 100);

        historyPrinter.print(new History(Arrays.asList(historyLine)));

        verify(historyLineFormatter).format(historyLine);
    }
}
