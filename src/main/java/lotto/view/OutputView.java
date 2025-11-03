package lotto.view;

import java.util.Arrays;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;
import lotto.message.OutputMessage;

public class OutputView {

    private static final String NEWLINE_BEFORE_AFTER = "%n%s%n";
    private static final String NEWLINE_WINNING_FORMAT = "%n%s%n%s%n";

    public void printError(String message) {
        System.out.printf(NEWLINE_BEFORE_AFTER, message);
    }

    public void printPurchaseResult(LottoTickets tickets) {
        printPurchaseHeader(tickets);
        printTickets(tickets);
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        printWinningHeaderWithSeparator();
        printRanks(winningStatistics);
    }

    public void printProfitRate(double profitRate) {
        System.out.println(OutputMessage.PROFIT_RATE_MESSAGE.format(profitRate));
    }

    private void printPurchaseHeader(LottoTickets tickets) {
        System.out.printf(NEWLINE_BEFORE_AFTER, OutputMessage.PURCHASE_COUNT_MESSAGE.format(tickets.size()));
    }

    private void printTickets(LottoTickets tickets) {
        tickets.values().forEach(System.out::println);
    }

    private void printWinningHeaderWithSeparator() {
        System.out.printf(NEWLINE_WINNING_FORMAT, OutputMessage.WINNING_STATISTICS_MESSAGE.getMessage(),
                OutputMessage.SEPARATOR.getMessage());
    }

    private void printRanks(WinningStatistics winningStatistics) {
        Arrays.stream(Rank.values())
                .filter(Rank::isWinning)
                .map(rank -> rank.format(winningStatistics.countOf(rank)))
                .forEach(System.out::println);
    }
}
