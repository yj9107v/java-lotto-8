package lotto.message;

public enum ExceptionMessage {

    CANNOT_INSTANCE_CLASS("[ERROR] %s 클래스는 인스턴스화 할 수 없습니다. "),
    INPUT_EMPTY("[ERROR] 입력값이 비어있습니다."),
    PURCHASE_AMOUNT_NOT_NUMERIC("[ERROR] 입력값은 숫자여야 합니다.(0, 음수, 공백 X)"),
    PURCHASE_AMOUNT_FORMAT("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다."),
    WINNING_NUMBERS_NOT_NUMERIC("[ERROR] 당첨 번호는 숫자와 구분자(,)로 이루어져야 합니다.(0, 음수, 공백 X)"),
    INTEGER_OVERFLOW("[ERROR] 입력값이 정수의 최댓값을 초과했습니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
