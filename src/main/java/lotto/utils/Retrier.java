package lotto.utils;

import lotto.view.OutputView;

public final class Retrier {
    private Retrier() {}

    public static <T> T untilValid(SupplierWithValidation<T> task, OutputView outputView) {
        while (true) {
            try {
                return task.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
