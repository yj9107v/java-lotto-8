package lotto.domain;

public enum Rank {

    MISS(0, false, 0L, ""),
    FIFTH(3, false, 5_000L, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, false, 50_000L, "4개 일치 (50,000원) - %d개"),
    THIRD(5, false, 1_500_000L, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final boolean bonusRequired;
    private final long prize;
    private final String message;

    Rank(int matchCount, boolean bonusRequired, long prize, String message) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
        this.message = message;
    }

    public static Rank of(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 &&  bonusMatched) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isWinning() {
        return this != MISS;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
