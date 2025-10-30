package lotto.validation;

import org.junit.platform.commons.util.StringUtils;

public final class CommonValidator {

    private CommonValidator() {
        throw new AssertionError("Cannot instantiate CommonValidator");
    }

    public static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}
