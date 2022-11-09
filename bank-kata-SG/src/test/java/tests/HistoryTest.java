package tests;

import bank.History;
import bank.HistoryLine;
import bank.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class HistoryTest {
	@Test
	public void showNewstHistory() {
		
		List<HistoryLine> historyLines = new ArrayList<HistoryLine>();
		historyLines.add(new HistoryLine(new Transaction(-50, new Date()), 50));
		historyLines.add(new HistoryLine(new Transaction(100, new Date()), 100));
		History expectedHistory = new History(historyLines);

		List<HistoryLine> historyLinesInTransactionsOrder = new ArrayList<HistoryLine>();
		historyLinesInTransactionsOrder.add(new HistoryLine(new Transaction(100, new Date()), 100));
		historyLinesInTransactionsOrder.add(new HistoryLine(new Transaction(-50, new Date()), 50));



		History history = History.create(historyLinesInTransactionsOrder);

		assertThat(history, equalTo(expectedHistory));
	}


}
