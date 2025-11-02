package lotto.domain;

import java.util.List;
import lotto.validation.LottoNumberValidator;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
    }

    public static WinningNumbers of(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        return new WinningNumbers(numbers);
    }

    public List<Integer> values() {
        return numbers;
    }
}
