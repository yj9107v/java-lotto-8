package lotto.domain;

import java.util.EnumMap;

public class WinningStatistics {

    private final EnumMap<Rank, Integer> counts = new EnumMap<>(Rank.class);

    private WinningStatistics() {
        for (Rank r : Rank.values()) counts.put(r, 0);
    }

    public static WinningStatistics of(Winning winning, LottoTickets tickets) {
        WinningStatistics winningStatistics = new WinningStatistics();
        tickets.values().forEach(t -> winningStatistics.increment(winning.rankOf(t)));
        return winningStatistics;
    }

    private void increment(Rank rank) {
        counts.put(rank, counts.get(rank) + 1);
    }

    public int countOf(Rank rank) {
        return counts.get(rank);
    }

    public long totalPrize() {
        return counts.entrySet().stream()
                .mapToLong(e -> e.getKey().getPrize() * e.getValue())
                .sum();
    }
}
