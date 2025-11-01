package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {

    private final LottoNumberGenerator generator;

    private LottoMachine(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public static LottoMachine withGenerator(LottoNumberGenerator generator) {
        return new LottoMachine(generator);
    }

    public Lotto issue() {
        return Lotto.of(generator.generate());
    }

    public List<Lotto> issueTickets(int ticketCount) {
        return Stream.generate(this::issue)
                .limit(ticketCount)
                .toList();
    }
}
