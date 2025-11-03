package lotto.view;

import java.util.Arrays;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;
import lotto.message.OutputMessage;

public class OutputView {


    public void printPurchaseResult(LottoTickets tickets) {
        printPurchaseHeader(tickets);
        printTickets(tickets);
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        printWinningHeaderWithSeparator();
        printRanks(winningStatistics);
    }

    private void printPurchaseHeader(LottoTickets tickets) {
        System.out.printf("%n%s%n", OutputMessage.PURCHASE_COUNT_MESSAGE.format(tickets.size()));
    }

    private void printTickets(LottoTickets tickets) {
        tickets.values().forEach(System.out::println);
    }

    private void printWinningHeaderWithSeparator() {
        System.out.printf("%n%s%n%s%n", OutputMessage.WINNING_STATISTICS_MESSAGE.getMessage(),
                OutputMessage.SEPARATOR.getMessage());
    }

    private void printRanks(WinningStatistics winningStatistics) {
        Arrays.stream(Rank.values())
                .filter(Rank::isWinning)
                .map(rank -> rank.format(winningStatistics.countOf(rank)))
                .forEach(System.out::println);
    }
}
