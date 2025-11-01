package lotto.infra;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Policy;

public class MissionUtilsLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Policy.MIN_NUMBER, Policy.MAX_NUMBER, Policy.NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
