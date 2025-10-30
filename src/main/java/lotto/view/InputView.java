package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.InputMessage;

public class InputView {

    private String readLine() {
        return Console.readLine();
    }

    public String askPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
        return readLine();
    }
}
