package lotto.domain;

import java.util.List;
import lotto.message.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Policy.NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
