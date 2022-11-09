package bank;

public class ConsoleHistoryPrinter implements HistoryPrinter {

    private final HistoryLineFormatter historyLineFormatter;
    private Screen screen;

    public ConsoleHistoryPrinter(final Screen screen,
                                   final HistoryLineFormatter historyLineFormatter) {
        this.historyLineFormatter = historyLineFormatter;
        this.screen = screen;
    }

    @Override
    public void print(History history) {
        if (history.isEmpty()) {
            return;
        }

        printHeader();

        for (HistoryLine historyLine : history) {
            printHistoryLine(historyLine);
        }
    }

    private void printHistoryLine(HistoryLine historyLine) {
        screen.printLine(historyLineFormatter.format(historyLine));
    }

    private void printHeader() {
        screen.printLine("DATE | AMOUNT | BALANCE");
    }
}
