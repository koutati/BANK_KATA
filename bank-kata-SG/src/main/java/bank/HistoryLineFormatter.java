package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryLineFormatter {

    private static final String FIELD_SEPARATOR = " | ";

    public String format(final HistoryLine historyLine) {
        return formatDate(historyLine.date()) + FIELD_SEPARATOR
                + formatMoney(historyLine.amount()) + FIELD_SEPARATOR
                + formatMoney(historyLine.balance());
    }

    private String formatMoney(final int amount) {
        return amount + ".00";
    }

    private String formatDate(final Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

}
