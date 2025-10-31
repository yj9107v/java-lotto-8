package lotto.utils;

import lotto.message.ExceptionMessage;
import lotto.validation.CommonValidator;

public class Parsed {

    public static int parseIntStrict(String input) {
        CommonValidator.validateBlank(input, ExceptionMessage.INPUT_EMPTY.getMessage());
        CommonValidator.validatePositiveNumeric(input, ExceptionMessage.NOT_NUMERIC.getMessage());
        return Integer.parseInt(input);
    }
}
