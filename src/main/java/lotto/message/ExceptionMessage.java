package lotto.message;

public enum ExceptionMessage {

    INPUT_EMPTY("[ERROR] 입력값이 비어있습니다."),
    NOT_NUMERIC("[ERROR] 입력값은 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
