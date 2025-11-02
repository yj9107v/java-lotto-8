package lotto.domain;

import lotto.message.ExceptionMessage;

public class PurchaseAmount {

    private final int amount;
    private static final int REMAINDER_ZERO = 0;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount of(int amount) {
        return new PurchaseAmount(amount);
    }

    private void validate(int amount) {
        if (amount % Policy.LOTTO_PRICE != REMAINDER_ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }

    public int toTicketCount() {
        return amount / Policy.LOTTO_PRICE;
    }

    public int value() {
        return amount;
    }
}
