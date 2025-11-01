package lotto.utils;

import lotto.message.ExceptionMessage;
import lotto.validation.CommonValidator;

public final class Parsed {

    private Parsed() {
        throw new AssertionError("No instances of Parsed");
    }

    public static int parseIntStrict(String input) {
        CommonValidator.validateBlank(input, ExceptionMessage.INPUT_EMPTY.getMessage());
        CommonValidator.validatePositiveNumeric(input, ExceptionMessage.NOT_NUMERIC.getMessage());
        return Integer.parseInt(input);
    }
}
