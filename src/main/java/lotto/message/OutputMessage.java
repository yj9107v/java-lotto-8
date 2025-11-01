package lotto.message;

public enum OutputMessage {

    PURCHASE_COUNT_MESSAGE("%n%d개를 구매했습니다.%n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
