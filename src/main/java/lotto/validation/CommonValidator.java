package lotto.validation;

import org.junit.platform.commons.util.StringUtils;

public final class CommonValidator {

    private final static String NUMERIC_PATTERN = "\\d+";

    private CommonValidator() {
        throw new AssertionError("Cannot instantiate CommonValidator");
    }

    public static void validateBlank(String input, String message) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumeric(String input, String message) {
        if (!input.equals(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(message);
        }
    }

}
