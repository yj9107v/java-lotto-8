package lotto.domain;

import java.util.List;
import lotto.validation.LottoNumberValidator;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> values() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
