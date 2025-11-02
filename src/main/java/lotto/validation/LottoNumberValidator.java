package lotto.validation;

import java.util.List;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Policy;
import lotto.message.ExceptionMessage;

public final class LottoNumberValidator {

    private LottoNumberValidator() {
        throw new AssertionError(ExceptionMessage.CANNOT_INSTANCE_CLASS.format(LottoNumberGenerator.class.getName()));
    }

    public static void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateNoDuplicate(numbers);
        validateRange(numbers);
    }

    public static void validateRange(int number) {
        validateNumberInRange(number);
    }

    private static void validateRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidator::validateNumberInRange);
    }

    private static void validateNumberInRange(Integer number) {
        if (number == null || number < Policy.MIN_NUMBER || number > Policy.MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != Policy.NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateNoDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Policy.NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }
}
