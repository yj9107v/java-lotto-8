package lotto.message;

public enum OutputMessage {

    PURCHASE_COUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    SEPARATOR("---"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
