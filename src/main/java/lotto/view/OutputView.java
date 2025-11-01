package lotto.view;

import lotto.domain.LottoTickets;
import lotto.message.OutputMessage;

public class OutputView {

    public void printPurchaseResult(LottoTickets tickets) {
        System.out.printf(OutputMessage.PURCHASE_COUNT_MESSAGE.getMessage(), tickets.size());
        tickets.values().forEach(System.out::println);
    }
}
