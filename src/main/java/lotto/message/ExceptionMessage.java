package lotto.message;

public enum ExceptionMessage {

    RETRY_INPUT_MESSAGE("다시 입력해주세요."),
    INPUT_EMPTY("[ERROR] 입력값이 비어있습니다." + RETRY_INPUT_MESSAGE);

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
