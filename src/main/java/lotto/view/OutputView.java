package lotto.view;

import lotto.domain.LottoTickets;
import lotto.message.OutputMessage;

public class OutputView {

    public void printPurchaseResult(LottoTickets tickets) {
        System.out.println(OutputMessage.PURCHASE_COUNT_MESSAGE.format(tickets.size()));
        tickets.values().forEach(System.out::println);
        System.out.println();
    }
}
