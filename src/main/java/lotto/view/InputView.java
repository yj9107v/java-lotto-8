package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.InputMessage;

public class InputView {

    public String askPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String askWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }
}
