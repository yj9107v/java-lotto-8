package lotto.domain;

import java.util.List;
import lotto.message.ExceptionMessage;

public class Winning {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private Winning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateNoDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Winning of(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new Winning(winningNumbers, bonusNumber);
    }

    public void validateNoDuplicate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.values().contains(bonusNumber.value())) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBERS_NOT_NUMERIC.getMessage());
        }
    }

    public WinningNumbers winningNumbers() {
        return winningNumbers;
    }

    public BonusNumber bonusNumber() {
        return bonusNumber;
    }

    public Rank rankOf(Lotto ticket) {
        List<Integer> win = List.copyOf(winningNumbers.values());
        int match = (int) ticket.values().stream().filter(win::contains).count();
        boolean bonusMatch = ticket.values().contains(bonusNumber.value());
        return Rank.of(match, bonusMatch);
    }


}
