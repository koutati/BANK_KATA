package bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class History implements  Iterable<HistoryLine>{

    private final List<HistoryLine> historyLines;


    public History(List<HistoryLine> historyLines) {
        this.historyLines = historyLines;
    }


    public boolean isEmpty() {
        return this.historyLines.isEmpty();
    }

    @Override
    public Iterator<HistoryLine> iterator() {
        return this.historyLines.iterator();
    }

    public static History create(List<HistoryLine> HistoryLinesInTransactionsOrder) {
        final ArrayList<HistoryLine> reversedList = new ArrayList<>(HistoryLinesInTransactionsOrder);
        Collections.reverse(reversedList);

        return new History(reversedList);
    }
}
