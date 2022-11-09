package tests;

import bank.*;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class HistoryPrinterTest {

    @Test
    public void showOnscreen() {
        List<HistoryLine> historyLines = new ArrayList<>();
        historyLines.add(new HistoryLine(new Transaction(500, new Date()), 1400));
        historyLines.add(new HistoryLine(new Transaction(-100, new Date()), 900));
        historyLines.add(new HistoryLine(new Transaction(1000, new Date()), 1000));
        History history = new History(historyLines);
        Screen screen = mock(Screen.class);
        InOrder inOrder = inOrder(screen);
        HistoryPrinter historyPrinter = new ConsoleHistoryPrinter(screen, new HistoryLineFormatter());

        historyPrinter.print(history);

        inOrder.verify(screen).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(screen).printLine("09/11/2022 | 500.00 | 1400.00");
        inOrder.verify(screen).printLine("09/11/2022 | -100.00 | 900.00");
        inOrder.verify(screen).printLine("09/11/2022 | 1000.00 | 1000.00");
    }
}
