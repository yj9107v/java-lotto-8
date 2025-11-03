package lotto.domain;

public class ProfitRate {

    private static final int PERCENT = 100;
    private final double rate;

    private ProfitRate(double rate) {
        this.rate = rate;
    }

    public static ProfitRate of(long totalPrize, int purchaseAmount) {
        return new ProfitRate(calculate(totalPrize, purchaseAmount));
    }

    private static double calculate(long totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * PERCENT;
    }

    public double value() {
        return rate;
    }
}
