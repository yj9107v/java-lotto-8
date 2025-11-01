package lotto.view;

import lotto.message.OutputMessage;

public class OutputView {

    public void printPurchaseResult(int ticketCount) {
        System.out.printf(OutputMessage.PURCHASE_RESULT.getMessage(), ticketCount);
    }
}
