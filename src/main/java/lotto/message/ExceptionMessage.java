package lotto.message;

public enum ExceptionMessage {

    INPUT_EMPTY("[ERROR] 입력값이 비어있습니다."),
    NOT_NUMERIC("[ERROR] 입력값은 숫자여야 합니다.(0, 음수, 공백 X)"),
    PURCHASE_AMOUNT_FORMAT("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다."),
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
}
