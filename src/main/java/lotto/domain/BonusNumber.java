package lotto.domain;

import lotto.validation.LottoNumberValidator;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber of(int number) {
        LottoNumberValidator.validateRange(number);
        return new BonusNumber(number);
    }

    public int value() {
        return number;
    }
}
