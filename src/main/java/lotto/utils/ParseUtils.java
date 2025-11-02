package lotto.utils;

import java.util.List;
import lotto.message.ExceptionMessage;
import org.junit.platform.commons.util.StringUtils;

public final class ParseUtils {

    private static final String DELIMITER = ",";
    private static final String NUMERIC_PATTERN = "[1-9]\\d*";


    private ParseUtils() {
        throw new AssertionError(ExceptionMessage.CANNOT_INSTANCE_CLASS.format(ParseUtils.class.getName()));
    }

    public static int parsePurchaseAmount(String input) {
        return parseIntStrict(input, ExceptionMessage.NOT_NUMERIC.getMessage());
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return splitByDelimiterStrict(input).stream()
                .map(token -> ParseUtils.parseIntStrict(token,
                        ExceptionMessage.WINNING_NUMBERS_NOT_NUMERIC.getMessage()))
                .toList();
    }

    public static int parseBonusNumber(String input) {
        return parseIntStrict(input, ExceptionMessage.NOT_NUMERIC.getMessage());
    }

    public static int parseIntStrict(String input, String message) {
        validateBlank(input);
        validatePositiveNumeric(input, message);
        validateIntegerRange(input);
        return Integer.parseInt(input);
    }

    public static List<String> splitByDelimiterStrict(String input) {
        validateBlank(input);
        return List.of(input.split(DELIMITER));
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY.getMessage());
        }
    }

    private static void validatePositiveNumeric(String input, String message) {
        if (!input.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateIntegerRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INTEGER_OVERFLOW.getMessage());
        }
    }
}
