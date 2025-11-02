package lotto.validation;

import java.util.List;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Policy;
import lotto.message.ExceptionMessage;

public final class LottoNumberValidator {

    private LottoNumberValidator() {
        throw new AssertionError(ExceptionMessage.CANNOT_INSTANCE_CLASS.format(LottoNumberGenerator.class.getName()));
    }

    public static void validateCount(List<Integer> numbers) {
        if (numbers.size() != Policy.NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateNoDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Policy.NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n == null || n < Policy.MIN_NUMBER || n > Policy.MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateCount(numbers);
        validateNoDuplicate(numbers);
        validateRange(numbers);
    }
}
