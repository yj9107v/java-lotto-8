package lotto;

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
import lotto.utils.Retrier;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        // 1) 구입금액 입력
        PurchaseAmount purchaseAmount = readPurchaseAmount();

        // 2) 로또 발행 및 발행한 로또 수량 및 번호 출력
        LottoTickets tickets = showIssueTickets(purchaseAmount);

        // 3) 당첨 번호 입력
        WinningNumbers winningNumbers = readWinningNumbers();

        // 4) 보너스 번호 입력 및 (당첨, 보너스 번호) 관리 및 중첩 여부 확인
        Winning winning = createWinningWithBonusNumber(winningNumbers);

        // 5) 당첨 통계 계산 및 출력
        WinningStatistics winningStatistics = showWinningStatistics(winning, tickets);

        // 6) 수익률 계산 및 출력
        showProfitRate(winningStatistics, purchaseAmount);
    }

    private PurchaseAmount readPurchaseAmount() {
        return Retrier.untilValid(
                () -> PurchaseAmount.of(ParseUtils.parsePurchaseAmount(inputView.askPurchaseAmount())), outputView);
    }

    private LottoTickets showIssueTickets(PurchaseAmount purchaseAmount) {
        LottoTickets tickets = issueTickets(purchaseAmount);
        printLottoTickets(tickets);
        return tickets;
    }

    private static LottoTickets issueTickets(PurchaseAmount purchaseAmount) {
        return LottoTickets.of(
                LottoMachine.withGenerator(new MissionUtilsLottoNumberGenerator())
                        .issueTickets(purchaseAmount.toTicketCount()));
    }

    private void printLottoTickets(LottoTickets tickets) {
        outputView.printPurchaseResult(tickets);
    }

    private WinningNumbers readWinningNumbers() {
        return Retrier.untilValid(
                () -> WinningNumbers.of(ParseUtils.parseWinningNumbers(inputView.askWinningNumbers())), outputView);
    }

    private Winning createWinningWithBonusNumber(WinningNumbers winningNumbers) {
        return Retrier.untilValid(() -> Winning.of(winningNumbers,
                BonusNumber.of(ParseUtils.parseBonusNumber(inputView.askBonusNumber()))), outputView);
    }

    private WinningStatistics showWinningStatistics(Winning winning, LottoTickets tickets) {
        WinningStatistics winningStatistics = calculateWinningStatistics(winning, tickets);
        getPrintWinningStatistics(winningStatistics);
        return winningStatistics;
    }

    private static WinningStatistics calculateWinningStatistics(Winning winning, LottoTickets tickets) {
        return WinningStatistics.from(winning, tickets);
    }

    private void getPrintWinningStatistics(WinningStatistics winningStatistics) {
        outputView.printWinningStatistics(winningStatistics);
    }

    private void showProfitRate(WinningStatistics winningStatistics, PurchaseAmount purchaseAmount) {
        ProfitRate profitRate = calculateProfitRate(winningStatistics, purchaseAmount);
        printProfitRate(profitRate);
    }

    private static ProfitRate calculateProfitRate(WinningStatistics winningStatistics, PurchaseAmount purchaseAmount) {
        return ProfitRate.of(winningStatistics.totalPrize(), purchaseAmount.value());
    }

    private void printProfitRate(ProfitRate profitRate) {
        outputView.printProfitRate(profitRate.value());
    }
}
