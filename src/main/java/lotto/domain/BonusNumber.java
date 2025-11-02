package lotto.domain;

import lotto.validation.LottoNumberValidator;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        LottoNumberValidator.validateRange(number);
        this.number = number;
    }

    public static BonusNumber of(int number) {
        return new BonusNumber(number);
    }

    public int value() {
        return number;
    }
}
