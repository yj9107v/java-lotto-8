package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.InputMessage;

public class InputView {

    public String askPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }
}
