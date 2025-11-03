package lotto;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.ProfitRate;
import lotto.domain.PurchaseAmount;
import lotto.domain.Winning;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.infra.MissionUtilsLottoNumberGenerator;
import lotto.utils.ParseUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private PurchaseAmount purchaseAmount;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private Winning winning;

    public void run() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.askPurchaseAmount();
                int rawPurchaseAmount = ParseUtils.parsePurchaseAmount(inputPurchaseAmount);
                purchaseAmount = PurchaseAmount.of(rawPurchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.printf("%n%s%n%n", e.getMessage());
            }
        }

        // 도메인 별 나누기??
        LottoTickets tickets = LottoTickets.of(
                LottoMachine.withGenerator(new MissionUtilsLottoNumberGenerator())
                        .issueTickets(purchaseAmount.toTicketCount()));
        outputView.printPurchaseResult(tickets);

        while (true) {
            try {
                String inputWinningNumbers = inputView.askWinningNumbers();
                List<Integer> rawWinningNumbers = ParseUtils.parseWinningNumbers(inputWinningNumbers);
                winningNumbers = WinningNumbers.of(rawWinningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.printf("%n%s%n", e.getMessage());
            }
        }

        while (true) {
            try {
                String inputBonusNumber = inputView.askBonusNumber();
                int rawBonusNumber = ParseUtils.parseBonusNumber(inputBonusNumber);
                bonusNumber = BonusNumber.of(rawBonusNumber);
                winning = Winning.of(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.printf("%n%s%n", e.getMessage());
            }
        }

        WinningStatistics winningStatistics = WinningStatistics.from(winning, tickets);
        outputView.printWinningStatistics(winningStatistics);

        ProfitRate profitRate = ProfitRate.of(winningStatistics.totalPrize(), purchaseAmount.value());
        outputView.printProfitRate(profitRate.value());
    }
}
